package study.java8to11._03_interface;

public interface Bar {

    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
