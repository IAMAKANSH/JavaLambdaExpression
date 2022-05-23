package com.modernjava.threading;

public class SupervisorExample {
    public static void main(String[] args) {

        WorkerA workerA=new WorkerA();
        WorkerB workerB=new WorkerB();
        try {
            workerA.executeWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workerB.executeWork();

    }

}
class WorkerA{

    public void executeWork() throws InterruptedException {
        for (int i=0;i<10;i++)
        {
            Thread.sleep(100);
            System.out.println("Worker A is executing task: "+i);
        }
    }

}
class  WorkerB
{
    public void executeWork()
    {
        for (int i=0;i<10;i++)
        {
            try {
                Thread.sleep(10);
                System.out.println("Worker B is executing task: "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
