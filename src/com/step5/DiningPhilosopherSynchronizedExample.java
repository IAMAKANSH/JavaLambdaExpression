package com.step5;

public class DiningPhilosopherSynchronizedExample {

    public static void main(String[] args) {

        Philosopher[] philosophers=new Philosopher[5];
        Object[] forks=new Object[5];

        for (int i=0;i<forks.length;i++)
        {
            forks[i]=new Object();
        }

        for (int i=0;i<philosophers.length;i++)
        {
            Object leftFork=forks[i];
            Object rightFork=forks[(i+1)%forks.length];
            philosophers[i]=new Philosopher(leftFork,rightFork);

            Thread t=new Thread(philosophers[i],"Philosopher"+(i+1));
            t.start();
        }
    }


}
class Philosopher implements  Runnable{

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {

        while (true)
        {
            doWork(System.currentTimeMillis()+": Thinking");
            synchronized (leftFork)
            {
                doWork(System.currentTimeMillis()+ ": Picked up left Fork");
                synchronized (rightFork)
                {
                    doWork(System.currentTimeMillis()+ ": Picked up right fork and eating");
                }
                doWork(System.currentTimeMillis()+ " Put down right fork");
            }
            doWork(System.currentTimeMillis()+ "Put down left fork and back to thinking");
        }

    }


    private void doWork(String s) {
        System.out.println(Thread.currentThread().getName()+ " "+ s);
        try {
            Thread.sleep((long) (Math.random()*100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}