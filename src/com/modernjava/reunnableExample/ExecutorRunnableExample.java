package com.modernjava.reunnableExample;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ExecutorRunnableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Runnable runnable=()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" finished executing at : "+ LocalDateTime.now());
        };

        ExecutorService executorService= Executors.newFixedThreadPool(10);
        System.out.println("First Example->>Executing task with execute() method");
        executorService.execute(runnable);
        System.out.println("Second Example-->>Exeuting task with submit method");
        Future<String> stringFuture=executorService.submit(runnable,"Completed");
        while(!stringFuture.isDone())
        {
            System.out.println("The method return value:: "+stringFuture.get());
        }
        executorService.shutdown();
    }
}
