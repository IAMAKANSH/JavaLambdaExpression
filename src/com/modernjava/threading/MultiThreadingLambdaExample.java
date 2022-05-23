package com.modernjava.threading;

import java.util.stream.IntStream;

public class MultiThreadingLambdaExample {

    public static  int[] arr= IntStream.rangeClosed(0,50000).toArray();
    public static int total=IntStream.rangeClosed(0,50000).sum();
    public static int sum=0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1=new Thread(()->{
            for (int i=0;i<arr.length/2;i++)
            {
               sum(arr[i]);
            }

        });
        Thread thread2=new Thread(()->{
            for (int i= arr.length/2;i<arr.length;i++)
            {
                sum(arr[i]);
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("sum is "+sum);
        System.out.println("Verification total "+total);
    }
    //when synchronized makes it serialize
    public synchronized static void sum(int toAdd)
    {
        sum=sum +toAdd;
    }
}
