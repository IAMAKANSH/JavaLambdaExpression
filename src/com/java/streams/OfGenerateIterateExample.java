package com.java.streams;

import java.util.Random;
import java.util.stream.Stream;

public class OfGenerateIterateExample {

    public static void main(String[] args) {

        //of

        Stream<Integer> streams=Stream.of(new Integer[]{1,2,3,4,5,6,7,8});
        streams.forEach(System.out::println);
        System.out.println("-------------------------");
        //iterate 10 even numbers
        Stream<Integer> integerStream=Stream.iterate(0,i->i+2).limit(10);
        integerStream.forEach(System.out::println);
        System.out.println("-------------------------");
        //generate
        Stream<Integer> integerStream1=Stream.generate(new Random()::nextInt).limit(10);
        integerStream1.forEach(System.out::println);

    }



}
