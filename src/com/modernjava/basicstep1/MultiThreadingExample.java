package com.modernjava.threading;

import java.util.stream.IntStream;

public class MultiThreadingExample {

    public static  int[] arr= IntStream.rangeClosed(0,50000).toArray();
    public static int total=IntStream.rangeClosed(0,50000).sum();
    public static int sum=0;
    public static void main(String[] args) throws InterruptedException {

        Worker1 worker1=new Worker1(arr);
        Worker2 worker2=new Worker2(arr);
        Thread thread1=new Thread(worker1);
        Thread thread2=new Thread(worker2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Sum of 50000 integers in parallel is "+sum);
        System.out.println("Lambda sum is "+total);

    }
    public static void sum(int toAdd)
    {
        sum=sum +toAdd;
    }
}

class Worker1 implements Runnable{

    int[] array;
    int sum=0;
    public Worker1(int[] arr){
        this.array=arr;
    }

    @Override
    public void run() {

        for (int i=0; i< array.length/2;i++)
        {
            sum +=array[i];
        }
        System.out.println("Worker 1 total sum is "+sum);
        MultiThreadingExample.sum(sum);
    }
}

class Worker2 implements Runnable{

    int[] array;
    int sum=0;
    public Worker2(int[] arr){
        this.array=arr;
    }

    @Override
    public void run() {
        for (int i=array.length/2; i< array.length;i++)
        {
            sum +=array[i];
        }
        System.out.println("Worker 2 total sum is "+sum);
        MultiThreadingExample.sum(sum);
    }
}
