package com.java.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

//        Integer[] numbers=new Integer[10];
//        int number=numbers[0].intValue();
//
//        System.out.println("number = "+number);

        Integer[] numbers=new Integer[10];
        Optional<Integer> optionalNullInt=Optional.ofNullable(numbers[0]);
        int result=optionalNullInt.isPresent()?optionalNullInt.get():-1;
        System.out.println("Result ="+result);

    }
}
