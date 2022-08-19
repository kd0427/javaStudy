package QueueWorker;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class QueueWorker<T> extends Thread {

    public static final int MAX_QUEUE_SIZE = 1000;

    private final int  maxQueueSize;
    private boolean safeStop = false;

    private final Queue<T> bufferToProcess;
    private ExecutorService execService;

    private boolean startOnce = true;

    public QueueWorker(int poolSize, int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
        bufferToProcess = new ArrayBlockingQueue<T>(this.maxQueueSize);
        execService = Executors.newFixedThreadPool(poolSize);
    }

    private synchronized void safeStart() {
        if (!this.isAlive() && startOnce) {
            this.start();
            startOnce = false;
        }
    }

    public Collection<T> safeStop() {
        safeStop = true;

        List<T> unprocessedJobs = new ArrayList<T>();
        if (execService instanceof ThreadPoolExecutor) {
            for (Runnable runnable : ((ThreadPoolExecutor) execService)
                    .shutdownNow()) {
                unprocessedJobs.add(((QueueWorkerRunnable) runnable).getJob());
            }
            return unprocessedJobs;
        }
        unprocessedJobs.addAll(bufferToProcess);
        clear();
        return unprocessedJobs;
    }

    public void push(T job) {
        bufferToProcess.add(job);
        if (!this.isAlive()) {
            safeStart();
        }
    }

    public void clear() {
        bufferToProcess.clear();
        if(execService != null) {
            execService.shutdown();
            execService = null;
        }
    }

    public int getQueueSize() {
        if(execService instanceof ThreadPoolExecutor) {
            return bufferToProcess.size() + ((ThreadPoolExecutor) execService).getQueue().size();
        }
        return bufferToProcess.size();
    }

    public Collection<T> getUnprocessedJob() {
        List<T> unprocessedJobs = new ArrayList<T>();
        if (execService instanceof ThreadPoolExecutor) {
            for (Runnable runnable : ((ThreadPoolExecutor) execService)
                    .getQueue()) {
                unprocessedJobs.add(((QueueWorkerRunnable) runnable).getJob());
            }
            return unprocessedJobs;
        }
        unprocessedJobs.addAll(bufferToProcess);
        return unprocessedJobs;
    }

    @Override
    public void run() {
        while (true) {
            sleepAwhile();
            final T job = bufferToProcess.poll();
            if (safeStop)
                break;

            if (job == null) {
                sleepAwhile();
                continue;
            }

            try {
                if (execService != null) {

                    execService.execute(new QueueWorkerRunnable(job));
                } else {
                    processObject(job);
                }
            } catch (Exception e) {
                handleException(job, e);
            }
        }
        clear();
    }
    private void sleepAwhile() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // do nothing.
        }
    }

    protected void handleException(T job, Exception e) {
        System.err.println("Exception occurred when process job, " + job);
        System.err.println("Exception Message, " + e.getMessage());
    }

    class QueueWorkerRunnable implements Runnable {
        private final T job;

        public QueueWorkerRunnable(T job) {
            this.job = job;
        }

        public void run() {
            try {
                processObject(job);
            } catch (Exception e) {
                handleException(job, e);
            }
        }

        public T getJob() {
            return job;
        }
    }

    public abstract void workQueueLoad(int payload);

    protected abstract void processObject(T o) throws Exception;
}
