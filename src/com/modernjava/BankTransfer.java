package com.modernjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransfer {

    private Double balance;
    private int id;
    private String accountName;

    final Lock lock=new ReentrantLock();

    public BankTransfer(Double balance, int id, String accountName) {
        this.balance = balance;
        this.id = id;
        this.accountName = accountName;
    }

    public boolean withdraw(double amount)
    {
        if(this.lock.tryLock())
        {
            try {
                Thread.sleep(100);
                balance -=amount;
                this.lock.unlock();
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    public boolean deposit(double amount)
    {
        if(this.lock.tryLock())
        {
            try {
                Thread.sleep(100);
                balance +=amount;
                this.lock.unlock();
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    public boolean transferAmt(BankTransfer to,double amount)
    {
        if(withdraw(amount))
        {
            System.out.println("Withdrawing amount : "+amount+"from "+accountName);
            if(to.deposit(amount))
            {
                System.out.println("Depositing amount is "+amount+" to "+to.accountName);
                return true;
            }
        }
        else
        {
            System.out.println("Failed to acquire both the locks:: refunding "+amount+"to::"+accountName);
            while(!deposit(amount))
            {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BankTransfer studentA=new BankTransfer(50000.00,1,"Anvay");
        BankTransfer university=new BankTransfer(1000000.00,2,"DTU");

        System.out.println("Initial balance of studentA is "+studentA.balance);
        System.out.println("Initial balance of university is "+university.balance);
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        Thread t=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" says executing transfer");
            while(!studentA.transferAmt(university,1000))
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            System.out.println(Thread.currentThread().getName()+" says transfer is successful");
        });
        for (int i=0;i<10;i++)
        {
            executorService.submit(t);
        }
        executorService.shutdown();
        while(true)
        {
            try {
                if (!!executorService.awaitTermination(24, TimeUnit.HOURS)) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Not Yet still waiting for termination");
        }
        System.out.println("ending balance of student is "+studentA.balance);
        System.out.println("ending balance of university is "+university.balance);
    }
}
