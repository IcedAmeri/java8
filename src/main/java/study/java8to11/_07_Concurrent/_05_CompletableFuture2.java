package study.java8to11._07_Concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class _05_CompletableFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        boolean throwError = false;
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });

        // 두  Thread 간에 연관 관계가 있을 때
        CompletableFuture<String> future1 = hello.thenCompose(_05_CompletableFuture2::getWorld);
        System.out.println(future1.get());

        // 두  Thread 간에 연관 관계가 없을 때
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future2 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future2.get());


        // 모든 작업을 기다린 후에 출력
        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
        results.get().forEach(System.out::println);


        // 모든 작업 중 하나만이라도 끝나면 출력
        CompletableFuture<Void> anyFuture = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        anyFuture.get();
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
