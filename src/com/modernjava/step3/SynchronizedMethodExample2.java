package com.modernjava.step3;

public class SynchronizedMethodExample2 {

    //FastFood Restaurant

    private String lastClientName;
    private  int noOfBurgersSold;

    public synchronized void buyBurger(String clientName)
    {
        aLongRunningProcess();
        this.lastClientName=clientName;
        noOfBurgersSold++;
        System.out.println("Burger bought ny client "+clientName);
    }

    public void aLongRunningProcess()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getLastClientName() {
        return lastClientName;
    }

    public void setLastClientName(String lastClientName) {
        this.lastClientName = lastClientName;
    }

    public int getNoOfBurgersSold() {
        return noOfBurgersSold;
    }

    public void setNoOfBurgersSold(int noOfBurgersSold) {
        this.noOfBurgersSold = noOfBurgersSold;
    }

    public static void main(String[] args) throws InterruptedException {

        Long startTime=System.currentTimeMillis();

        SynchronizedMethodExample2 example=new SynchronizedMethodExample2();

        Thread t1=new Thread(() -> {
            example.buyBurger("Akansh");
        });
        Thread t2=new Thread(() -> {
            example.buyBurger("Jay");
        });
        Thread t3=new Thread(() -> {
            example.buyBurger("Mansi");
        });
        Thread t4=new Thread(() -> {
            example.buyBurger("Bob");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();;
        t2.join();;
        t3.join();
        t4.join();
        Long endTime=System.currentTimeMillis();
        System.out.println("Total number of burger sold "+example.getNoOfBurgersSold());
        System.out.println("The last client is "+example.getLastClientName());
        System.out.println("Total time taken "+(endTime-startTime));
    }
}
