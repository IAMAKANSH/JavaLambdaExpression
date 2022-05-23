package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SteamReduceExample {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(1,2,5,6,8,9,4,3);

        int result=list.stream().reduce(0,(a,b)->a+b);
        System.out.println(result);

        Optional result1=list.stream().reduce((a, b)->a+b);
        if(result1.isPresent())
        {
            System.out.println(result1.get());
        }

    }
}
