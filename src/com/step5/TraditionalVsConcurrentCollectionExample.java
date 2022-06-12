package com.step5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class TraditionalVsConcurrentCollectionExample {

   public static final CyclicBarrier CYCLIC_BARRIER=new CyclicBarrier(2);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

concurrentModificationArrayList();

    }

    public static void concurrentModificationArrayList() throws BrokenBarrierException, InterruptedException {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<10000;i++)
        {
            list.add(i);
        }

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                CYCLIC_BARRIER.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Adding 5000 to the list");
            list.add(5000);
        }).start();

        Iterator<Integer> it=list.iterator();
        boolean flag=false;
        while (it.hasNext())
        {

            it.next();
            if (flag)
            {
                CYCLIC_BARRIER.await();
                flag=true;
            }
        }
    }
}
