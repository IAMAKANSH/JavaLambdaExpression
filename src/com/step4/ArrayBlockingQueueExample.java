package com.step4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(5);

        Runnable producer=() -> {
            int i=0;
            while (true)
            {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    queue.put(++i);
                    System.out.println("Added "+i);
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer=() -> {

            while (true)
            {
                Integer poll;
                try {
                    poll=queue.take();
                    System.out.println("Polled :"+poll);
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.shutdown();
    }

}
