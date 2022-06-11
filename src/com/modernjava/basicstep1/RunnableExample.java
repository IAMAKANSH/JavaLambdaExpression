package com.modernjava.threading;

public class RunnableExample {
    public static void main(String[] args) {
        //Runnable Traditional example

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int sum=0;
                for (int i=0;i<10;i++)
                {
                    sum +=i;

                }
                System.out.println("Traditional approach "+sum);
            }
        };
        new Thread(runnable).start();

        //lambda expression

        Runnable runnable1=()->{
            int sum=0;
            for (int i=0;i<10;i++)
            {
                sum +=i;
            }
            System.out.println("Lambda approach "+sum);
        };
        new Thread(runnable1).start();

        //Implement using thread with Lamdba

                new Thread(()->{
                    int sum=0;
                    for (int i=0;i<10;i++)
                    {
                        sum +=i;
                    }
                    System.out.println("Sum is "+sum);
                }).start();

    }
}
