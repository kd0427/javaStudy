package Lamda.lambdaTestStudentAvg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTestAvg {

    static List<Student> list = Arrays.asList(
            new Student("김씨", 95, 92, "남자"),
            new Student("김씨", 95, 92, "남자"),
            new Student("이씨", 87, 90,"여자"),
            new Student("서씨", 86, 94,"여자"),
            new Student("전씨", 80, 77,"여자")
    );

    public static double getMethScoreAvg(Predicate<Student> studentGender){
        int count=0;
        double sum=0;
        for(Student student : list){
            if(studentGender.test(student)){
                count++;
                sum+=student.getMathScore();
            }
        }
        return sum/count;
    };

    public static void main(String[] args){
      double femaleAvg = getMethScoreAvg(student -> student.getGender().equals("여자"));
      System.out.println("여자의 수학점수 평균: "+femaleAvg);
    }
}
