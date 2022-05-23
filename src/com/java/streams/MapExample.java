package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {

        //return only instructor names from the instructors list

        List<Instructor> instructorList= Instructors.getAll() ;
        Set<String> names=instructorList.stream().map(Instructor::getName).peek(System.out::println).
                map(String::toUpperCase).peek(System.out::println).collect(Collectors.toSet());
        System.out.println(names);
    }
}
