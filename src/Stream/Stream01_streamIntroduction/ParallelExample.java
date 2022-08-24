package Stream.Stream01_streamIntroduction;

import Lamda.MethodReferences.Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ParallelExample {
    static int sum=0;
    public static void stop(int time) {
       try {
           Thread.sleep(time);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public static String print(){
        return  Thread.currentThread().getName();
    }
    public static void main(String[] args){




        List<String> list = Arrays.asList("김씨","전씨","강씨","조씨","정씨","채씨");

        // 순차 처리
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        Stream<String> stream = list.stream();
        stream.forEach( name ->{
            stop(1000);
            System.out.println(name+"---"+ print());
        });
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("처리시간: "+secDiffTime+"초");

        // 병렬 처리
        long beforeTime2 = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(name->{
            stop(1000);
            System.out.println(name+"---"+ print());
        });
        long afterTime2 = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime2 = (afterTime2 - beforeTime2)/1000; //두 시간에 차 계산
        System.out.println("처리시간: "+secDiffTime2+"초");

    }
}
