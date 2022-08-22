package JavaEnum.Enum_2;


enum Direction {

    // 열거형 상수에 다른값을 줄 수 있다.
    // EAST("동쪽", 1) 여러개 도가능

    EAST("동쪽"),
    SOUTH("남쪽"),
    WEST("서쪽"),
    NORTH("북쪽");

    // 값을 넣으려면 변수와 생성자를 추가해야한다.
    private final String symbol; // symbol 을 저장할 변수

    Direction(String symbol){ // 생성자
     this.symbol = symbol;
    }
    public String getSymbol(){
        return symbol;
    }
}

public class EnumTest2 {
    public static void main(String[] args){
        Direction d = Direction.EAST;

        System.out.println(d.getSymbol());
    }
}
