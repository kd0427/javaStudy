package JavaEnum.Enum_1;

import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnumTest {
    public static void main(String[] args){
        Week today = null;

        Calendar cal = Calendar.getInstance();

        int getDay = cal.get(Calendar.DAY_OF_WEEK);

        switch(getDay){
            case 1 : today = Week.valueOf("SUNDAY"); break;
            case 2 : today = Week.MONDAY; break;
            case 3 : today = Week.TUESDAY; break;
            case 4 : today = Week.WEDNESDAY; break;
            case 5 : today = Week.THURSDAY; break;
            case 6 : today = Week.valueOf("FRIDAY"); break;
            case 7 : today = Week.SATURDAY; break;
        }

        System.out.println("오늘은 "+ today);

        if(today == Week.SUNDAY){
            System.out.println("오늘은 쉬는날");
        }else{
            System.out.println("공부하자");
        }

        Week[] days = Week.values();

        Arrays.stream(days).forEach(System.out::println);

        String number = IntStream.range(1,11).boxed()
                .filter(x -> x%2==0)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println(number);


    }
}
