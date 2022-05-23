package com.java.streams;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StreanMaxExample {

    public static void main(String[] args) {

        List<Integer> integerList= Arrays.asList(1,2,4,7,8,9,3);
        long start = System.currentTimeMillis();
        System.out.println("countdown started====="+ start);
        //max
        Optional result=integerList.stream().max(Integer::compareTo);
        if(result.isPresent())
        {
            System.out.println(result.get());
        }
        long finish = System.currentTimeMillis();
        System.out.println("Operation 1 completed "+(finish-start));
        long start1=System.currentTimeMillis();
        int result2=integerList.stream().reduce(0,(integer1, integer2) -> integer1>integer2?integer1:integer2);
        long finish2=System.currentTimeMillis();
        System.out.println("Operation 2 ends "+(finish2-start1) +" Ans is "+result2);
    }
}
