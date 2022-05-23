package com.java.optional;

import java.util.Optional;

public class OptionalIfPresentIsPresent {

    public static void main(String[] args) {

        //isPresent

        Optional<String> s=Optional.ofNullable("Hello World");
        if(s.isPresent())
            System.out.println(s.get());
        else
            System.out.println(-1);

        //if present
        s.ifPresent(System.out::println);


    }
}
