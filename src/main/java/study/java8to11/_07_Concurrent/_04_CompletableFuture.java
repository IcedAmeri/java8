package study.java8to11._07_Concurrent;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _04_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletedFuture
        CompletableFuture<String> future = CompletableFuture.completedFuture("keesun");
        System.out.println(future.get());

        // 리턴값이 없는 경우
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("Hello: " + Thread.currentThread().getName());
        });
        runAsync.get();

        // 리턴값이 있는 경우
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello: " + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(supplyAsync.get());

        // 이후 동작을 콜백으로 추가
        // + 쓰레드풀 직접 제공
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<String> supplyAsyncThen = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello: " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenApplyAsync((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase(Locale.ROOT);
        }, executorService);
        // thenAccept - 리턴 없어도 됨
        // thenRun - 파라미터, 리턴 없이 그냥 하기만 하면 됨

        System.out.println(supplyAsyncThen.get());

        executorService.shutdown();
    }
}
