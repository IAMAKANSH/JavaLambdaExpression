package com.java.funcprogramming;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        Function<Integer,Double> sqrt=n->Math.sqrt(n);

        System.out.println("Square root of 64 "+ sqrt.apply(64));
        System.out.println("Square root of 81 "+ sqrt.apply(81));

        Function<String,String> lowerCaseFunction=(s)->s.toLowerCase();
        System.out.println(lowerCaseFunction.apply("Programming"));

        Function<String,String> concatFunction=(s)->s.concat(" In java");
        System.out.println(lowerCaseFunction.andThen(concatFunction).apply("Programming"));

        System.out.println(lowerCaseFunction.compose(concatFunction).apply("Programming"));


    }
}
