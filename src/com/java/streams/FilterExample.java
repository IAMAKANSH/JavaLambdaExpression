package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

    public static void main(String[] args) {
        //returing instructor sorted by names and have more than 10 years of experience

        List<Instructor> list= Instructors.getAll().stream().filter(instructor -> instructor.getYearOfExperience()>=10).sorted(Comparator.comparing(Instructor::getName)).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
