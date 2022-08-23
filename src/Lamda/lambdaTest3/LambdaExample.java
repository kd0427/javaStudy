package Lamda.lambdaTest3;

public class LambdaExample {

    public static void main(String[] args){

        Runnable runnable = ()->{
            for(int i=0; i<10; i++){
                System.out.println(i);
            }
        };

        // 1
        Thread thread = new Thread(runnable);
        thread.start();

        //2
        Thread thread2 = new Thread(()->{
           for(int i=0;i<10;i++){
               System.out.println(i);
           }
        });
    }
}
