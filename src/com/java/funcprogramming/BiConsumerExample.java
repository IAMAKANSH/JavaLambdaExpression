package com.java.funcprogramming;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        //printing out two numbers
        BiConsumer<Integer,Integer> biConsumer=(x,y)-> System.out.println(x+x + y+y);
        biConsumer.accept(10,10);


        BiConsumer<String,String> biConsumer1=(x,y)-> System.out.println(x+" "+y);
        biConsumer1.accept("Akansh","Srivastava");

        BiConsumer<Integer,Integer> biConsumer3=(x,y)-> System.out.println(x+","+y);
        biConsumer3.accept(10,10);



    }



}
