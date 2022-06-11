package com.modernjava.step3;

import java.util.stream.IntStream;

public class SumOfNumbersUsingRunnable {

    public static int[] numbers = IntStream.rangeClosed(0, 5000).toArray();
    public static int[] numbers2 =IntStream.rangeClosed(5001,10000).toArray();
    public static int sum = 0;
    public static int total = IntStream.rangeClosed(0, 10000).sum();
    public static void main(String[] args) throws InterruptedException {


        Worker1 worker1 = new Worker1(numbers);
        Worker2 worker2 = new Worker2(numbers2);

        Thread thread=new Thread(worker1);
        Thread thread1=new Thread(worker2);
        thread.start();
        thread1.start();

        //thread1.start();
        //the join method allows one thread to wait for the completion of another thread
        //when we invoke the join() meathod on a thread, the calling thread goes into the waiting state.
        //it reamins waiting state until the referenced thread terminates
        //what iiiffff
        //the join method will keep waiting if the referenced thread is bloacked which can
        //become the issue as the calling thread will become non-responsive.
        //Java provided two overloaded version of the join () method that takes timeout period
        thread.join();
        thread1.join();
        System.out.println(sum);
        System.out.println(total);
    }

    public static void add(int toAdd) {
        sum = sum + toAdd;
    }
}
    class Worker1 implements Runnable{
        int[] arr;
        int sum;

        public Worker1(int[] arr) {
            this.arr=arr;
        }

        @Override
        public void run() {
            for (Integer i:arr)
            {
                sum+=i;
            }
            SumOfNumbersUsingRunnable.add(sum);
        }
    }

    class Worker2 implements  Runnable{

        int[] arr;
        int sum;

        public Worker2(int[] arr) {
            this.arr=arr;
        }

        @Override
        public void run() {
            for (Integer i:arr)
            {
                sum+=i;
            }
            SumOfNumbersUsingRunnable.add(sum);
        }
    }
