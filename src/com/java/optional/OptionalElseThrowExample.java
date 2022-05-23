package com.java.optional;

import java.util.Optional;

public class OptionalElseThrowExample {

    public static void main(String[] args) throws Exception {

        //orElse

        Integer[] numbers=new Integer[10];
        numbers[0]=1;
        Optional<Integer> numberOptional=Optional.ofNullable(numbers[1]);
        int result=numberOptional.orElse(-1);
        System.out.println(result);

        //orElseGet
        result=numberOptional.orElseGet(()->-1);
        System.out.println(result);

        //orElseThrow

        result=numberOptional.orElseThrow(Exception::new);
        System.out.println(result);

    }
}

