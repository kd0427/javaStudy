package Lamda.lambdaTest3;

public class ExampleTest {
    public int outerField = 10;

    class Inner {
        int innerField =20;

        void method(){
            //람다식
            MyFunctionalInterface fi = () -> {
                // 바깥 객체 참조 클래스명.this
                System.out.println("outerField: "+ ExampleTest.this.outerField);
                // 람다식 내부 this 는 Inner 객체 참조
                System.out.println("innerField: "+ this.innerField);
            };
            fi.method();
        }
    }
    public static void main(String[] args){
        ExampleTest exampleTest = new ExampleTest();
        ExampleTest.Inner inner = exampleTest.new Inner();

        inner.method();
    }
}
