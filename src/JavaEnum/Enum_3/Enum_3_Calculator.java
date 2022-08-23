package JavaEnum.Enum_3;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;

@FunctionalInterface
interface MyFunctional<T , U, R> {
    R myFunction( T t , U u);
}
enum Operator {
    PLUS("+", (num1, num2) -> String.valueOf(num1 + num2)),
    MINUS("-", (num1, num2) -> String.valueOf(num1 - num2)),
    MULTIPLY("*", (num1, num2) -> String.valueOf(num1 * num2)),
    DIVIDE("/", (num1, num2) -> String.valueOf(num1 / num2)),
    WRONG("wrong",(num1,num2)->"잘못된 연산자 입니다.");
    private final String symbol;
//    private final BiFunction<Integer, Integer, String> expression;
    private final MyFunctional<Integer, Integer, String> expression;



    Operator(String symbol, MyFunctional<Integer,Integer,String> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public String getSymbol(){
        return symbol;
    }

    public static Operator cal(String symbol){
            for(Operator operator : Operator.values()){
                if(operator.getSymbol().equals(symbol)){
                    return operator;
                }
            }
        return null;
    }

    public static void calculate(int num1, int num2, String symbol){

        String result = Optional.ofNullable(cal(symbol))
                        .orElse(valueOf("WRONG"))
                        .expression.myFunction(num1,num2);

        System.out.println(result);
    }
}

public class Enum_3_Calculator {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        String cal = sc.next();
        int num2 = sc.nextInt();


        Operator.calculate(num1,num2,cal);
    }
}
