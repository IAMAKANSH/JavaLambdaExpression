package com.modernjava.help;

import java.security.SecureRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RandomGenerator {
    static  int count=0;
    static int[] dice= IntStream.rangeClosed(1,6).toArray();
    public static void main(String[] args) {
        Predicate<Integer> predicate=(a)->a==6;
        long start,end=0;
        start=System.currentTimeMillis();
        for (int i=0;i<1000;i++)
        {
           if(predicate.test(getDice()))
           {
               System.out.println("Hurrah its 6");
               count++;
           }
        }
        end=System.currentTimeMillis();
        System.out.println("Total time consumed is "+(end-start));
        Function<Integer,Double> doubleFunction=(a)->{
            return (((double)a)/1000)*100;
        };
        System.out.println("The answer is "+doubleFunction.apply(count));
    }
    static int getDice()
    {
        Supplier<Integer> supplier=()->{
            int randomIndex=new SecureRandom().nextInt(dice.length);
            System.out.println("Generated Random index is "+randomIndex);
            System.out.println("Dice choosen is "+dice[randomIndex]);
            return dice[randomIndex];
        };
        return supplier.get();
    }
}
