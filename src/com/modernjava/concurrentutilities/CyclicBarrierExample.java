package com.modernjava.concurrentutilities;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CyclicBarrierExample {

    public static int[] arr1= IntStream.rangeClosed(0,5000).toArray();
    public static int[] arr2=IntStream.rangeClosed(5001,10000).toArray();
    public static int[] arr3=IntStream.rangeClosed(10001,15000).toArray();
    public static int total= IntStream.rangeClosed(0,15000).sum();
    final static CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, ExecutionException {

        Callable callable1=()->{

            int sum=0;
            sum=sum+calculateSum(0,arr1.length/2,arr1);
            cyclicBarrier.await();
            sum=sum+calculateSum(0,arr2.length/2,arr2);
            cyclicBarrier.await();
            sum=sum+calculateSum(0,arr3.length/2,arr3);
            cyclicBarrier.await();
            return sum;
        };
        Callable callable2=()->{

            int sum=0;
            sum=sum+calculateSum(arr1.length/2,arr1.length,arr1);
            cyclicBarrier.await();
            sum=sum+calculateSum(arr2.length/2,arr2.length,arr2);
            cyclicBarrier.await();
            sum=sum+calculateSum(arr3.length/2,arr3.length,arr3);
            cyclicBarrier.await();
            return sum;
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<Integer> future1=executorService.submit(callable1);
        Future<Integer> future2=executorService.submit(callable2);

        System.out.println("Calculating first sum ");
        cyclicBarrier.await();
        System.out.println("First sum is calculated");

        System.out.println("Calculation second sum");
        cyclicBarrier.await();
        System.out.println("second sum is calculated");

        System.out.println("Calculating third sum");
        cyclicBarrier.await();
        System.out.println("Third sum is calculated");

        int sum =future1.get()+future2.get();
        System.out.println("Sum of three array is "+sum);
        System.out.println("correct array is "+total);
        executorService.shutdown();

    }

    private static int calculateSum(int start,int end,int[] array)
    {
        int sum1=0;
        for (int i=start;i<end;i++)
        {
            sum1=sum1+array[i];
        }
        return sum1;
    }

}
