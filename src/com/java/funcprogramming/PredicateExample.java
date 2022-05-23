package com.java.funcprogramming;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        //id number is greater than 10 return true else false

        Predicate<Integer> predicate=(i)->i>10;
        System.out.println(predicate.test(100));

        //if i>10 && number is even (i%2==0)
        Predicate<Integer> predicate1=(i)->i%2==0;
        System.out.println(predicate.and(predicate1).test(101));

        //i>10 or i is an even number (i%2==0)

        System.out.println(predicate.or(predicate1).test(101));

        //i>0 and  i%2 !=0

        System.out.println(predicate.and(predicate1.negate()).test(33));

    }
}
