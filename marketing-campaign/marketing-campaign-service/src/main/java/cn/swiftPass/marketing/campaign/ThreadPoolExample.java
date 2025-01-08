package cn.swiftPass.marketing.campaign;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Submit tasks to the pool
        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
            });
        }

        // Shut down the executor
        executor.shutdown();
    }
}

