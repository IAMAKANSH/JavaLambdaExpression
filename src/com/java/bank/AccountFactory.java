package com.java.bank;

public interface AccountFactory {

    public abstract BankAccount getBankAccount(int id,double balance,String accountName);
}
