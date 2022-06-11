package com.modernjava.threading;

public class SupervisorExampleMultiThreading {

    public static void main(String[] args) {

        ParallelWorker1 parallelWorker1=new ParallelWorker1();
        ParallelWorker2 parallelWorker2=new ParallelWorker2();

        parallelWorker1.start();
        parallelWorker2.start();

    }
}

class ParallelWorker1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            try {
                Thread.sleep(100);
                System.out.println("Worker A is working ::"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class ParallelWorker2 extends Thread{

    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            try {
                Thread.sleep(100);
                System.out.println("Worker B is working ::"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
