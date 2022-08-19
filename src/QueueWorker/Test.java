package QueueWorker;

public class Test {
    public static void main(String[] args){



        QueueWorker<MessageObject> queueWorker = new QueueWorker<MessageObject>(5,10) {
            @Override
            public void workQueueLoad(int payload) {

            }

            @Override
            protected void processObject(MessageObject o) throws Exception {
                int sum=0;
                System.out.println("-------------");
                for(int i=0; i<o.getMsg();i++){
                    sum+= i;
                    System.out.println("input message: "+i+" sum: "+sum);
                };
            }

        };

        for(int i=0; i<10; i++){
            queueWorker.push(new MessageObject((int)(Math.random()*100)));
        }


    }
}
