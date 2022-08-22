package Lamda;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args){
        Predicate<Integer> p1 = i -> i < 100;
        Predicate<Integer> p2 = i -> i < 200;
        Predicate<Integer> p3 = i -> i%2==0;

        Predicate<Integer> notP1 = p1.negate(); // i >= 100 (!p1)
        Predicate<Integer> all = notP1.and(p2).or(p3); // i>=100 && i<200 || i%2==0 100이상 200미만 or 짝수
        Predicate<Integer> all2 = notP1.and(p2.or(p3)); // i>=100 && (i<200 || i%2==0)

        System.out.println(all.test(4));
        System.out.println(all2.test(202)); // 100~199 or 200부터는 짝수만
    }

}
