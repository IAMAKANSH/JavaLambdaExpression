package com.java.funcprogramming;

import java.util.Comparator;
import java.util.function.*;

public class BinaryOperatorExample {

    public static void main(String[] args) {

       //Sum of two number using binary operator

        BinaryOperator<Integer> binaryOperator=(a,b)->a+b;
        System.out.println(binaryOperator.apply(10,20));

        //Calculating max

        Comparator<Integer> comparator =(a,b)->a.compareTo(b);

        BinaryOperator<Integer> binaryOperator1=BinaryOperator.maxBy(comparator);
        System.out.println(binaryOperator1.apply(10,7));

        BinaryOperator<Integer> binaryOperator2=BinaryOperator.minBy(comparator);
        System.out.println(binaryOperator2.apply(10,7));

        IntBinaryOperator intBinaryOperator=(a,b)->a*b;
        System.out.println(intBinaryOperator.applyAsInt(10,20));

        LongBinaryOperator longBinaryOperator=(a,b)->a/b;
        System.out.println(longBinaryOperator.applyAsLong(10,10));

        DoubleBinaryOperator doubleBinaryOperator=(a,b)->a*b;
        System.out.println(doubleBinaryOperator.applyAsDouble(20.2,10));



    }
}
