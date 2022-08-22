package JavaEnum;

import java.util.Scanner;
import java.util.function.BiFunction;

enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private  String symbol;
    private  BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    void calculate(int num1, int num2){
       System.out.println(expression.apply(num1, num2)) ;
    }

}


public class Enum_3_Calculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        String cal = sc.next();
        int num2 = sc.nextInt();



        Operator.PLUS.calculate(1,2);
    }
}
