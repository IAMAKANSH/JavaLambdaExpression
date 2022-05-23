package com.modernjava.reunnableExample;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorCallaableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<String> callable=()->{
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Current Time is "+ LocalDateTime.now();
        };

        ExecutorService executorService= Executors.newFixedThreadPool(1);
        List<Callable<String>> taskList= Arrays.asList(callable,callable);
        System.out.println("First Example using invokeALl");
        List<Future<String>> results=executorService.invokeAll(taskList);
        for (Future<String> result:results)
        {
            System.out.println("The result is "+result.get());
        }
        System.out.println("First Example using submit");
        Future<String> resFuture=executorService.submit(callable);
        while(!resFuture.isDone())
        {
            System.out.println("The method return value "+resFuture.get());
        }
        executorService.shutdown();
    }
}
