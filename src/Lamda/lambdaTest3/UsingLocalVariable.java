package Lamda.lambdaTest3;

public class UsingLocalVariable {
    void method(int arg){
        int localVar = 40;

        // arg , localVar 은 람다식에서 사용하고 있기 때문에 final 특성을 가짐
        // 수정 불가

        MyFunctionalInterface fi = () -> {
          System.out.println("arg: "+ arg);
          System.out.println("localVar: "+ localVar);
        };

        fi.method();
    }
}
