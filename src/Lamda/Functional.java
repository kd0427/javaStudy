package Lamda;

@FunctionalInterface
interface MyFunction{
    void run();
}


public class Functional {

    static void execute(MyFunction f){ // 매개변수의 타입이 MyFunction 인 메소드
        f.run();
    }

    static MyFunction getMyFunction(){ // 반환 타입이 MyFunction 인 메소드
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args){
        // 람다식으로 MyFunction 의 run() 을 구현
        MyFunction f1 = () -> System.out.println("f1.run()");

        // 익명클래스로 MyFunction 의 run() 을 구현
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(()->System.out.println("f1.run()"));
    }
}
