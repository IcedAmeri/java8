package study.java8to11._03_interface;

public class App {
    public static void main(String[] args) {
        // 기본 메소드
        Foo foo = new DefaultFoo("keesun");
        foo.printName();
        foo.printNameUpperCase();

        // 스태틱 메소드
        Foo.printAnything();
    }
}
