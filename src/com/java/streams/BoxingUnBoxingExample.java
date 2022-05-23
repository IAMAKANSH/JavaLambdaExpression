package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnBoxingExample {

    public static void main(String[] args) {

        List<Integer> list;

        IntStream intStream=IntStream.rangeClosed(0,5000); //primitive int stream

        list=intStream.boxed().collect(Collectors.toList());
        list.forEach(System.out::println);

        int sum=list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum is "+sum);
    }
}
