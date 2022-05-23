package com.java.funcprogramming;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateExample3 {
    public static void main(String[] args) {


        IntPredicate p1=(i)->i>100;
        System.out.println(p1.test(20));

        LongPredicate p2=(i)->i>100L;
        System.out.println(p2.test(200000000000000000L));

        DoublePredicate p3=(i)->i>50.0;
        DoublePredicate p4=(i)->i<100.0;
        System.out.println(p3.test(100.0));

        System.out.println(p3.and(p4).test(108.0));
    }
}
