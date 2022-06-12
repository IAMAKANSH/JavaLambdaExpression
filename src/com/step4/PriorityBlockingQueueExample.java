package com.step4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {

    public static void main(String[] args) {

        final String[] name= {"Mike","Siyar","Bob","Akansh","Andrew"};

        final PriorityBlockingQueue<String> priorityBlockingQueue=new PriorityBlockingQueue();

        Runnable runnable=() ->
        {
           for (String n:name)
           {
               priorityBlockingQueue.put(n);
           }
        };

        Runnable consumer=() -> {

            while (!priorityBlockingQueue.isEmpty())
            {
                try {
                    System.out.println(priorityBlockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        executorService.submit(runnable);
        executorService.submit(consumer);
        executorService.shutdown();

    }

}
