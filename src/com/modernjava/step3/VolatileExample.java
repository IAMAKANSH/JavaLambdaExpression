package com.modernjava.step3;

public class VolatileExample    {
    public static volatile  boolean flag=false;

    public static void main(String[] args) {

        new Thread(() -> {

            for (int i=0;i<2000;i++)
            {
                System.out.println("Value of i is"+ i);
            }
            flag=true;
            System.out.println("The value of flag is "+flag);
        }).start();

        new Thread(() -> {

            int i=1;
            while (!flag)
            {
                ++i; }
            System.out.println("The value of second thread i is "+i);
        }).start();

    }
}
