package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComparator {

    public static void main(String[] args) {
        //returning all instructor sorted by their name

        List<Instructor> list= Instructors.getAll().stream().sorted(Comparator.comparing(Instructor::getName).reversed()).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
