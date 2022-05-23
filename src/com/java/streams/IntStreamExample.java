package com.java.streams;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntStreamExample {

    public static void main(String[] args) {

        //using of

        IntStream intStream=IntStream.of(1,2,3,4,5);
        intStream.forEach(System.out::println);
        System.out.println("------------------------------");
        //iterate
        IntStream intStream1=IntStream.iterate(0,i->i+2).limit(10);
        intStream1.forEach(System.out::println);

        System.out.println("------------------------------");

        IntStream intStream2=IntStream.generate(new Random()::nextInt).limit(5);
        intStream2.forEach(System.out::println);

        System.out.println("------------------------------");

        //range
        IntStream intStream3=IntStream.range(0,5);
        intStream3.forEach(System.out::println);

        //rangeCLosed
        System.out.println("------------------------------");

        IntStream intStream4=IntStream.rangeClosed(1,5);
        intStream4.forEach(System.out::println);

        //DOuble

        DoubleStream doubleStream= LongStream.rangeClosed(0,5).asDoubleStream();
        doubleStream.forEach(System.out::println);

        DoubleStream doubleStream1=DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(10.0)).limit(10);
        doubleStream1.forEach(System.out::println);


    }
}
