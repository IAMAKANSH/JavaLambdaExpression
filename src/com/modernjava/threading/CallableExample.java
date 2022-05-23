package com.modernjava.threading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallableExample {

        public static int[] arr=IntStream.rangeClosed(0,50000).toArray();
        public static  int total=IntStream.rangeClosed(0,50000).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable=()->{

            int sum=0;
            for (int i=0;i<arr.length/2;i++)
            {
                sum +=i;
            }
            return sum;
        };
        Callable callable1=()->{
            int sum=0;
            for (int i=arr.length/2;i<arr.length;i++)
            {
                sum +=i;
            }
            return sum;
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList= Arrays.asList(callable,callable1);
        List<Future<Integer>> futures=executorService.invokeAll(taskList);
        int k=0;
        int sum=0;
        for (Future<Integer> future:futures
             ) {
            sum +=future.get();
            System.out.println("sum of "+ ++k +"is :"+future.get());
        }
        System.out.println("Sum from the callable is "+sum);
        System.out.println("calculated sum is "+total);
        executorService.shutdown();
    }

}
