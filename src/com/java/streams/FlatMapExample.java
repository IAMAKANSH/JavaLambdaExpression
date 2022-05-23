package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {

        //get the list of courses  which instructor offers

        List<Instructor> instructorList= Instructors.getAll();
        Set<String> courses=instructorList.stream().map(Instructor::getCourses).
                flatMap(List::stream).collect(Collectors.toSet());
        System.out.println(courses);
    }
}
