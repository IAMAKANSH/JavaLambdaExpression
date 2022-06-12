package com.step4;

import java.util.concurrent.*;

public class LinkedBlockingQueueExample {

    public static void main(String[] args) {

        LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>(5);

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
