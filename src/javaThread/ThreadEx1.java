package javaThread;

public class ThreadEx1 {
    public static void main(String[] args){

        // Thead 클래스
        ThreadExtendsThread threadExtendsThread = new ThreadExtendsThread();
        threadExtendsThread.start();

        // Runnable 인터페이스
        ThreadRunnable threadRunnable = new ThreadRunnable();
        threadRunnable.run();
    }
}

class ThreadExtendsThread extends Thread{
    public void run(){
        int sum=0;
        int random = (int)(Math.random()*100);
        for(int i=1; i<=random; i++){
            sum += i;
        }
        System.out.println("Thread 상속----"+sum);
        
    }
}

class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        int sum=0;
        int random = (int)(Math.random()*100);
        for(int i=1; i<=random; i++){
            sum += i;
        }
        System.out.println("Runnable 인터페이스----"+sum);
    }
}