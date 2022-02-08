package study.java8to11;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
//        foo.functionalInterface();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스 - shadowing
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 - shadowing
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }

    private void functionalInterface() {
        // 익명 내부 클래스 anonymous inner class
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };

        // 익명 내부 클래스 anonymous inner class -> 람다 형태
//        RunSomething runSomething = (number) -> {
//            return number + 10;
//        };
//        System.out.println(runSomething.doIt(1));

        // Function<T, R> : 파라미터, 리턴 모두 존재
        Function<Integer, Integer> plus10 = (i) -> i+10;
        Function<Integer, Integer> multiply2 = (i) -> i*2;
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));

        System.out.println(plus10.andThen(multiply2).apply(2));

        // Consumer<T> : 리턴 없이 소비
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier<T> : 파라미터 없이 리턴만
        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10.get() = " + get10.get());

        // Predicate<T> : Boolean 으로 true false 리턴
        Predicate<String> startWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        //  UnaryOperator : 파라미터, 리턴 값 모두 동일 타입
        UnaryOperator<Integer> plus11 = (i) -> i+11;
        System.out.println("plus11.apply(2) = " + plus11.apply(2));


        // 람다 함수
        BinaryOperator<Integer> sum = (a, b) -> a + b;
    }
}
