package com.java.bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankTransfer {

    public static void main(String[] args) {
        AccountFactory accountFactory = BankAccount::new;
        BankAccount studentBankAccount = accountFactory.getBankAccount(1, 50000, "Akansh Srivastava");
        BankAccount srmUniversityBankAccount = accountFactory.getBankAccount(1, 5000000, "SRM University");

        BiPredicate<Double, Double> p1 = (balance, amount) -> balance > amount;
        BiConsumer<String, Double> printer = (x, y) -> System.out.println(x + y);
        BiConsumer<BankAccount, BankAccount> printer2 = (student, university) ->
                System.out.println("Ending balance of student account: " + studentBankAccount.getBalance() + " Univesity account:" + srmUniversityBankAccount.getBalance());
        ExecutorService service = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(() ->
        {
            System.out.println(Thread.currentThread().getName() + "says:: Executing Transfer");
            try {
                double amount = 1000;
                if (!p1.test(studentBankAccount.getBalance(), amount)) {
                    printer.accept(Thread.currentThread().getName() + "says::Balance Insufficient, ", amount);
                    return;
                }
                while (!studentBankAccount.transfer(srmUniversityBankAccount, amount)) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    continue;
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            printer.accept(Thread.currentThread().getName() + " says transfer is successful :Balance in account ", srmUniversityBankAccount.getBalance());
        });
        for (int i = 0; i < 20; i++) {
            service.submit(t1);
        }
        service.shutdown();
        try {
            while (!service.awaitTermination(24L, TimeUnit.HOURS)) {
                System.out.println("Not Yet. Still waiting for termination");
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        printer2.accept(studentBankAccount, srmUniversityBankAccount);
    }
}
