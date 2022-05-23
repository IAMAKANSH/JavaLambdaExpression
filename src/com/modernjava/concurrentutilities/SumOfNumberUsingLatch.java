package com.modernjava.concurrentutilities;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SumOfNumberUsingLatch {

    public static int[] arr=IntStream.rangeClosed(0,50000).toArray();
    public static int total= IntStream.rangeClosed(0,50000).sum();
    final static CountDownLatch countDownLatch=new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable=()->{

            int sum=0;
            for (int i=0;i<arr.length/2;i++)
            {
                sum=sum+arr[i];
            }
            countDownLatch.countDown();
            return sum;
        };

        Callable callable1=()->{

            int sum=0;
            for (int i=arr.length/2;i<arr.length;i++)
            {
                sum=sum+arr[i];
            }
            countDownLatch.countDown();
            return sum;
        };

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<Integer> sum1=executorService.submit(callable);
        Future<Integer> sum2=executorService.submit(callable1);
        System.out.println("Count down latch count for calling the await "+countDownLatch.getCount());
        countDownLatch.await();
        System.out.println("No of count down after await is ::"+countDownLatch.getCount());
        int sum=sum1.get()+ sum2.get();
        System.out.println("Sum of the thread is "+sum);
        System.out.println("Verification sum is "+total);
        executorService.shutdown();
    }
}

