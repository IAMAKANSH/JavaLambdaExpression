package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamMinExample {

    public static void main(String[] args) {

        List<Integer> integerList= Arrays.asList(1,2,4,7,8,9,3);

        Optional result=integerList.stream().min(Integer::compareTo);
        System.out.println(result.get());

        Optional result2=integerList.stream().reduce((a,b)->a<b?a:b);
        System.out.println(result2.get());

        Optional result3=integerList.stream().reduce(Integer::min);
        System.out.println(result2.get());
    }
}
