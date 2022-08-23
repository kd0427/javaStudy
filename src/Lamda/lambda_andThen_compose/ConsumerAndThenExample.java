package Lamda.lambda_andThen_compose;

import java.util.function.Consumer;

public class ConsumerAndThenExample {
    public static void main(String[] args) {
        Consumer<Member> consumerA = m -> System.out.println("회원이름: "+m.getName());

        Consumer<Member> consumerB = m -> System.out.println("회원아이디: "+m.getId());

        Consumer<Member> consumerAB = consumerA.andThen(consumerB);

        Consumer<Member> consumerC = m-> System.out.println(m.getAddress().getCity());

//        Consumer<Member> con

        consumerAB.accept(new Member("홍길동","대도", new Address("한국","서울")));
    }
}
