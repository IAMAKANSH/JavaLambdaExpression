package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkipExample {

    public static void main(String[] args) {

        List<Integer> integerList= Arrays.asList(1,2);

        List limitNumber=integerList.stream().limit(5).collect(Collectors.toList());
        limitNumber.forEach(System.out::println);

        System.out.println("-----------------------");
        List skipNumber=integerList.stream().skip(5).collect(Collectors.toList());
        System.out.println(skipNumber);

    }
}
