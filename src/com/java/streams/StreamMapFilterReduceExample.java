package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

public class StreamMapFilterReduceExample {

    public static void main(String[] args) {
        //total year of experience b/w instructors

        Integer result=Instructors.getAll().stream().filter(instructor -> instructor.isOnlineCourses()).map(Instructor::getYearOfExperience).reduce(0,Integer::sum);
        System.out.println(result);

    }
}
