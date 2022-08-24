package Lamda.MethodReferences;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class Calculator {
    String name;
    public static int staticAdd(int num1, int num2){
        return num1+num2;
    };

    public int instanceAdd(int num1, int num2){
        return num1 + num2;
    };

    public Calculator(String name){
        this.name = name;
    }

    public static void main(String[] args){
        IntBinaryOperator operator;

        Function<String,Calculator> function = Calculator::new; // 생성자 참조
        Calculator calculator = function.apply("참조");

        operator = (num1,num2)->Calculator.staticAdd(num1,num2);
        operator = Calculator::staticAdd; // static 메소드 참조

        operator = (num1,num2)->calculator.instanceAdd(num1,num2);
        operator = calculator::instanceAdd; // instance 메소드 참조
    }
}
