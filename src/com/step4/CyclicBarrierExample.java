package com.step4;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CyclicBarrierExample {

    public static  int[] array1= IntStream.rangeClosed(0,5000).toArray();
    public static  int[] array2= IntStream.rangeClosed(5001,10000).toArray();
    public static  int[] array3= IntStream.rangeClosed(10001,15000).toArray();

    private static  int total=IntStream.rangeClosed(0,15000).sum();
    private final static CyclicBarrier CYCLIC_BARRIER=new CyclicBarrier(3);
    public static void main(String[] args) throws ExecutionException, InterruptedException, BrokenBarrierException {

        Callable<Integer> callable1=() -> {
            int sum=0;

            for (int i=0;i<array1.length/2;i++)
                sum +=array1[i];
            CYCLIC_BARRIER.await();
            for (int i=0;i<array2.length/2;i++)
                sum +=array2[i];
            CYCLIC_BARRIER.await();
            for (int i=0;i<array3.length/2;i++)
                sum +=array3[i];
            CYCLIC_BARRIER.await();
            return sum;
        };

        Callable<Integer> callable2=() -> {
            int sum=0;

            for (int i=array1.length/2;i<array1.length;i++)
                sum +=array1[i];
            CYCLIC_BARRIER.await();
            for (int i=array2.length/2;i<array2.length;i++)
                sum +=array2[i];
            CYCLIC_BARRIER.await();
            for (int i=array3.length/2;i<array3.length;i++)
                sum +=array3[i];
            CYCLIC_BARRIER.await();
            return sum;
        };

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<Integer> sum1=executorService.submit(callable1);
        Future<Integer> sum2=executorService.submit(callable2);

        System.out.println("Calculating first sum");
        CYCLIC_BARRIER.await();
        System.out.println("First sum is calculated");

        System.out.println("Calculating second sum");
        CYCLIC_BARRIER.await();
        System.out.println("Second sum is calculated");


        System.out.println("Calculating third sum");
        CYCLIC_BARRIER.await();
        System.out.println("Third sum is calculated ");


        System.out.println((sum1.get()+sum2.get())+" Sum");
        System.out.println("verified sum "+total);
        executorService.shutdown();
    }
}
