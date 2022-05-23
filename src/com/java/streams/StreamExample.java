package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {

        //Creating a map of names and courses of instructors who teaches online and have more than 10 years of experience

        Predicate<Instructor> predicate=(p)-> p.isOnlineCourses();
        Predicate<Instructor> predicate1=(p)->p.getYearOfExperience()>10;

        List<Instructor> instructors= Instructors.getAll();

        Map<String,List<String>> map=instructors.stream().filter(predicate).filter(predicate1).collect(Collectors.toMap(Instructor::getName,Instructor::getCourses));

        System.out.println(map);
    }
}
