package com.modernjava.reunnableExample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallabaleSumExample {

    public static int[] arr=IntStream.rangeClosed(0,50000).toArray();
    public static int total =IntStream.rangeClosed(0,50000).sum();
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable=()->{
            int sum=0;
            for (int i=0;i<arr.length/2;i++)
            {
                sum +=arr[i];
            }
            return sum;
        };
        Callable callable1=()->{
            int sum=0;
            for (int i=arr.length/2;i<arr.length;i++)
            {
                sum +=arr[i];
            }
            return sum;
        };

        ExecutorService service= Executors.newFixedThreadPool(2);
        List<Callable<Integer>> listCallables= Arrays.asList(callable,callable1);
        List<Future<Integer>> future=service.invokeAll(listCallables);
        int k=0;
        int sum=0;
        for (Future<Integer> result:future)
        {
            sum=sum+result.get();
            System.out.println("Sum of "+ (++k) +" is :: "+result.get());
        }
        System.out.println("Sum from thr threads  is :: "+sum);
        System.out.println("Correct sum is "+total);
        service.shutdown();
    }
}
