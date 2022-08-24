package Stream.Stream01_streamIntroduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressionsExample {

    public static void main(String[] args){
        List<Student> list = Arrays.asList(
                new Student("김씨",99),
                new Student("서씨",100)
        );

        Stream<Student> stream = list.stream();
        stream.forEach(student ->{
           String name = student.getName();
           int score = student.getScore();
           System.out.println("학생:"+name+" 점수:"+score);
        });
    }
}
