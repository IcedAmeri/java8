package study.java8to11._07_Concurrent;

public class _01_ConcurrentApp {
    public static void main(String[] args) throws InterruptedException {
        // 방식 1 - Thread 상속
        /*
        Mythread mythread = new Mythread();
        mythread.start();
        System.out.println("Hello1: " + Thread.currentThread().getName());
        */

        // 방식 2 - Runnable(람다)
        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello2: " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
//        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread + " is finished");
    }

    static class Mythread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread: " + Thread.currentThread().getName());
        }
    }

}
