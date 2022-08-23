package Lamda.lambdaTest3;

public class MyFunctionalInterfaceTest {
    public static void main(String[] args){

        MyFunctionalInterface fi = () -> System.out.println("Hello");
        fi.method();
    }
}
