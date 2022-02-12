package study.java8to11._07_Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _02_ExecutorApp {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(getRunnable("Hello"), 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
        executorService.submit(getRunnable("KeeSun"));
        executorService.submit(getRunnable("The"));
        executorService.submit(getRunnable("Java"));
        executorService.submit(getRunnable("Thread"));

//        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> {
            System.out.println(message + Thread.currentThread().getName());
        };
    }
}
