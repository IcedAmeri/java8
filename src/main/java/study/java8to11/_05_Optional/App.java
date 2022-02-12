package study.java8to11._05_Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        OnlineClass onlineClass = optional.orElseGet(App::createNewClass);
        System.out.println(onlineClass.getTitle());

        OnlineClass noOnlineClass = optional.orElseThrow(IllegalAccessError::new);

        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
