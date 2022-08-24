package Stream.Stream01_streamIntroduction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Iterator_StreamExample {
    public static void main(String[] args){
        List<String> list = Arrays.asList("김씨","박씨","전씨");

        // Iterator 이용
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
        System.out.println("-----");
        // Stream 이용
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }
}
