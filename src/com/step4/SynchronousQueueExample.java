package com.step4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueExample {


    public static void main(String[] args) {
        String[] arr={"Akansh","Saiyar","Bob","Mike","Jenny"};
        SynchronousQueue<String> queue=new SynchronousQueue<>();

        Runnable producer=() -> {
            for (String n:arr)
            {
                try {
                    queue.put(n);
                    System.out.println("Inserted : "+n +" in a queue");
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer=() -> {

            while (true)
            {
                try {
                    System.out.println("Retrieved: "+queue.take()+ " from the queue");
                    TimeUnit.MILLISECONDS.sleep(2000);

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
