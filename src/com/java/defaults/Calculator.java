package com.java.defaults;

public interface Calculator {

    //abstract sum method
    public int sum(int num1,int num2);

    //default method which is substract
    default int substract(int num1,int num2)
    {
        return num1-num2;
    }
    //static method
    static int multiply(int num1,int num2)
    {
        return num1*num2;
    }
}
