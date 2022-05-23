package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.stream.Collectors;

public class StreamsSummingIntAveragingInt {

    public static void main(String[] args) {

        //SummingInt

        int sum=Instructors.getAll().stream().collect(Collectors.summingInt(Instructor::getYearOfExperience));
        System.out.println(sum);

        //averagingInt
        double average=Instructors.getAll().stream().collect(Collectors.averagingInt(Instructor::getYearOfExperience));

        System.out.println(average);


    }
}
