package Lamda;


public class Lamda_Test {
    /* 람다식
    * 함수(메소드)를 간단한 식으로 표현하는 방법
    *
    * 익명 함수
    * 1 메서드의 이름과 반환타입을 제거하고 -> 를 블록 {} 앞에 추가한다.
    * 2 반환값이 있는 경우 , 식이나 값만 적고 return 문 생략 가능 (끝에 ; 안 붙임)
    * 3 매개변수의 타입이 추론 가능하면 생략가능(대부분의 경우 생략가능)
    *
    * 매개변수가 하나인 경우, 괄호() 생략 가능(타입이 없을때만)
    * 블록 안의 문장이 하나 뿐 일때, 괄호{} 생략가능(끝에 ; 안붙임)
    * 단, 하나뿐인 문장이 return 문이면 괄호{} 생략뷸가
    *
    * 람다식은 익명객체
    */

    // Object obj = (a,b) -> a > b ? a:b;
    MaxFunction obj = new MaxFunction(){
        public int max(int a, int b){
            return a > b? a:b;
        }
    };

    //   int value = obj.max(3,6); Object 클래스에는 max 라는 메소드가 없어서 사용할 수 없다.

    // 람다식은 익명 객체이기 때문에 참조변수가 필요하고
    // 그 참조 변수는 함수형 인터페이스 타입으로 해야한다.
    MaxFunction maxFunction = (a,b)-> a > b ? a : b;

}

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
interface MaxFunction{
    int max(int a , int b);
}