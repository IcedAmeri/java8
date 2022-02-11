package study.java8to11._03_interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        // 기본 메소드
        Foo foo = new DefaultFoo("keesun");
        foo.printName();
        foo.printNameUpperCase();

        // 스태틱 메소드
        Foo.printAnything();

        // Iterable
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("===========");
        while (spliterator1.tryAdvance(System.out::println));

        // removeIf
        name.removeIf(s -> s.startsWith("k"));
        name.forEach(System.out::println);

        // comparator
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
    }
}
