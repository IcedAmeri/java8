package study.java8to11.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {

        // instance 함수 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        // static 함수 참조조
//       UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hi = Greeting::hi;

        // 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();  // <- 이 시점에서 생성됨

        // 생성자 (with 파라미터) 참조
        Function<String, Greeting> keesunGreeting = Greeting::new;
        Greeting keesun = keesunGreeting.apply("keesun");
        System.out.println(keesun.getName());

        //
        String[] names = {"keesun", "whiteship", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
