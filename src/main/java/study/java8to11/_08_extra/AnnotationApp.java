package study.java8to11._08_extra;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘 간장")
public class AnnotationApp {
    public static void main( String[] args) {
        List<String> names = Arrays.asList("keesun");
        Chicken[] chickens = AnnotationApp.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        ChickenContainer chickenContainer = AnnotationApp.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

//    static class FeelsLikeChicken<@Chicken T> {
//
//        public static <@Chicken C> void print(@Chicken C c) {
//            System.out.println(c);
//        }
//    }
}
