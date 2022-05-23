package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.stream.Collectors;

public class TerminalOperationCounting {

    public static void main(String[] args) {

        //no of instructors who teaches online course
        //stream.count

        Long insLong= Instructors.getAll().stream().filter(Instructor::isOnlineCourses).count();
        System.out.println(insLong);

        Long aLong=Instructors.getAll().stream().filter(Instructor::isOnlineCourses).collect(Collectors.counting());
        System.out.println(aLong);
    }
}
