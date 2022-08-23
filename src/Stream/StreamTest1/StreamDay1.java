package Stream.StreamTest1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDay1 {
    public static void main(String[] args){
       String result = IntStream.range(1,11).boxed()
                        .filter(x -> x%2==0)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));

       System.out.println("1~10짝수"+result);

       List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
       System.out.println(inputList1);
        inputList1.stream()
                .map(x->x.split(" "))
                .forEach(System.out::println);
    }
}
