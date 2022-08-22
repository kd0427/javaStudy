package Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionPackage {
    /*
    *    Java 에서 제공하는 함수형 인터페이스
    *   Runnable - void run() - 매개변수도 없고, 반환값도 없음.
    *   Supplier<T> - T get() - 매개변수는 없고 반환값만 있음.
    *   Consumer<T> - void accept(T t) - 매개변수만 있고 반환값이 없음.
    *   Function<T,R> R apply(T t) - 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환
    *   Predicate<T> boolean test(T t) - 조건식을 표현하는데 사용됨, 매개변수는 하나, 반환 타입은 boolean
    */

    /*
        매개변수가 2개인 함수형 인터페이스
        BiConsumer<T,U> - void accept(T t, U u) - 두개의 매개변수만 있고, 반환값이 없음
        BiPredicate<T,U> - boolean test(T t, U u) - 조건식을 푠현하는데 사용됨. 매개변수는 둘, 반환값은 boolean
        BiFunction<T,U,R> - R apply(T t, U u) - 두개의 매개변수를 받아서 하나의 결과를 반환
    */

    /*
        매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스
       UnaryOperator<T> - T apply(T t) - Function 의 자손, Function 과 달리 매개변수와 결과의 타입이 같다.
       BinaryOperator<T> - T apply(T t, T t) - BiFunction 의 자손, BiFunction 과 달리 매개변수와 결과의 타입이 같다.
    */

    public static void main(String[] args){
        Supplier<Integer> supplier = ()->(int)(Math.random()*45)+1;
        Consumer<Integer> consumer = i -> System.out.print(i+", ");
        Predicate<Integer> predicate = i -> i%2==0;
        Function<Integer,Integer> function = i -> i/10*10;

        List<Integer> list = new ArrayList<Integer>();
        makeRandomList(supplier, list);
        System.out.println(list);

        printEventNum(predicate,consumer,list);

        List<Integer> newList = doSomething(function,list);
        System.out.println(newList);
    }
    static <T> void makeRandomList(Supplier<T> supplier, List<T> list){
        for(int i =0; i<6; i++){
            list.add(supplier.get());
        }
    }

    static <T> void printEventNum(Predicate<T> p , Consumer<T> c, List<T> list){
        System.out.print("[");
        for(T i: list){
            if(p.test(i)) { // 짝수면
                c.accept(i); // 콘솔출력
            }
        }
        System.out.print("]");
        System.out.println();
    }

    static <T> List<T> doSomething(Function<T,T> f, List<T> list){
        List<T> newList = new ArrayList<T>(list.size());
        for(T i : list){
            newList.add(f.apply(i));
        }
        return newList;
    }
}
