package com.java.funcprogramming;

import java.util.function.*;

public class UnaryOperatorExample {

    public static void main(String[] args) {

        UnaryOperator<Integer> unaryOperator=(i)->i*10;
        System.out.println(unaryOperator.apply(10));

        //with function

        Function<Integer,Integer> function=i->i*10;
        System.out.println(function.apply(10));

        IntUnaryOperator intUnaryOperator=(i)->i*10;
        System.out.println(intUnaryOperator.applyAsInt(100));

        LongUnaryOperator longUnaryOperator=(l)->l*10;
        System.out.println(longUnaryOperator.applyAsLong(100000000l));

        DoubleUnaryOperator doubleUnaryOperator=i-> i * 10.0;
        System.out.println(doubleUnaryOperator.applyAsDouble(20.0));
    }
}
