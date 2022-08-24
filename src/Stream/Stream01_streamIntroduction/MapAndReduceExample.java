package Stream.Stream01_streamIntroduction;


import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("김씨", 89),
                new Student("서씨", 95),
                new Student("김씨2", 90)
        );

        double avg = studentList.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);


        System.out.println(avg);

    }
}
