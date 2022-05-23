package com.java.streams;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamNumericOperationExample {
    public static void main(String[] args) {
        //sum
        int sum= IntStream.rangeClosed(0,200).sum();
        System.out.println("sum is"+ sum);

        //min
        OptionalInt min=IntStream.rangeClosed(0,1000).min();
        System.out.println(min.getAsInt()+"----------"+min);

        //max
        OptionalInt max=IntStream.rangeClosed(0,1000).max();
        System.out.println(max.getAsInt()+"--------------"+max);

        //average
        OptionalDouble average= LongStream.rangeClosed(0,1000).asDoubleStream().average();
        System.out.println(average.getAsDouble()+"---------------"+average);
    }
}
