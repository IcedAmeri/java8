package study.java8to11;

public class Foo {
    public static void main(String[] args) {
        // 익명 내부 클래스 anonymous inner class
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };

        // 익명 내부 클래스 anonymous inner class -> 람다 형태
        RunSomething runSomething = (number) -> {
            return number + 10;
        };
        System.out.println(runSomething.doIt(1));
    }
}
