package com.modernjava.step3;

public class SemaphoreExample {

    ///BoundCollection

    private int signal=0;
    public synchronized void take()
    {
        this.signal++;
        this.notify();
    }

    public synchronized  void release() throws InterruptedException {

        while (this.signal==0)
        {
            wait();
        }
        this.signal--;
    }

    public static void main(String[] args) {

        SemaphoreExample countingSemaphore=new SemaphoreExample();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ " is called and value of signal is "+countingSemaphore.signal);
            countingSemaphore.take();
        },"take").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ " is called and value of signal is "+countingSemaphore.signal);
            try {
                countingSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"release").start();
    }
}
