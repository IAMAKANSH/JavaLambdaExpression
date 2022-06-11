package com.modernjava.step3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransferLock {

    private double balance;
    private int id;
    private String accountName;
    final Lock lock= new ReentrantLock();

    public BankTransferLock(double balance, int id, String accountName) {
        this.balance = balance;
        this.id = id;
        this.accountName = accountName;
    }

    public boolean withdraw(double amount) throws InterruptedException {
        if(this.lock.tryLock())
        {
            Thread.sleep(100);
            balance -=amount;
            this.lock.unlock();
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) throws InterruptedException {
        if (this.lock.tryLock())
        {
            Thread.sleep(100);
            balance +=amount;
            this.lock.unlock();
            return true;
        }
        return false;
    }


    public boolean transfer(BankTransferLock to, double amount) throws InterruptedException {

        if (withdraw(amount))
        {
            System.out.println("Withdrawing amount : "+amount + " from "+accountName);
            if (to.deposit(amount))
            {
                System.out.println("Depositing amount : "+amount+ "to "+amount);
                return true;
            }
            else
            {
                System.out.println("Failed to acquire both locks : refunding "+amount+ "to :"+accountName);
                while (!deposit(amount))
                {
                    continue;
                }
            }
        }
        return false;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}

class Driver{

    public static void main(String[] args) {

        BankTransferLock student=new BankTransferLock(50000,1,"Akansh Srivaastava");
        BankTransferLock university=new BankTransferLock(5000000,2,"SRM");

        System.out.println("Starting balance of student account is "+student.getBalance());
        System.out.println("Starting balance of university account is "+university.getBalance());


        ExecutorService executorService= Executors.newFixedThreadPool(10);

        Thread t=new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ "says ::Executing Transfer");
            try
            {
                while (!student.transfer(university,10000))
                {
                    Thread.sleep(100);
                    continue;
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " says transfer is successful");
        });

        for (int i=0;i<20;i++)
        {
            executorService.submit(t);
        }
        executorService.shutdown();
try {
    while (!executorService.awaitTermination(24L, TimeUnit.HOURS)) {
        System.out.println("Not Yet. Still waiting for termination");
    }
}catch (InterruptedException e)
{
    e.printStackTrace();
}
        System.out.println("Student balance of ending balace is "+student.getBalance());
        System.out.println("University balance "+university.getBalance());
    }


}
