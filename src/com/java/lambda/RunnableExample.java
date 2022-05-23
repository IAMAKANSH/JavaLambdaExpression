package com.java.lambda;

public class RunnableExample {

    public static void main(String[] args) {
        //Runnable traditional way

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int sum=0;
                for (int i=0;i<10;i++)
                    sum +=i;
                System.out.println("Traditional Way "+sum);
            }
        };
        new Thread(runnable).start();

        //Implement using lambda

        Runnable runnable1=() ->{
            int sum=0;
            for (int i=0;i<20;i++)
                sum +=i;
            System.out.println("Using lambda "+sum);
        };
        new Thread(runnable1).start();

        //Simpler way to implement using thread and lambda

        new Thread(()->{
            int sum=0;
            for (int i=0;i<25;i++)
                sum+=i;
            System.out.println("Simpler Lambda "+sum);
        }).start();
    }
}
