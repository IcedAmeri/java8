package study.java8to11._07_Concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class _03_Callable_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        /* Callable and Future
        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        helloFuture.cancel(false);  // 작업 취소 (get 불가능)
        System.out.println(helloFuture.isDone());

        helloFuture.get();   // 블록킹 콜

        System.out.println(helloFuture.isDone());
        System.out.println("End!");
         */

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "Keesun";
        };

        /* invokeAll
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, keesun));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        */

        // invokeAny
        String s = executorService.invokeAny(Arrays.asList(hello, java, keesun));
        System.out.println(s);

        executorService.shutdown();
    }
}
