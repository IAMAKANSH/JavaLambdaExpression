package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {

        //Count and distinct

        List<Instructor> instructorList= Instructors.getAll();
        Long courses=instructorList.stream().map(Instructor::getCourses).
                flatMap(List::stream).distinct().count();
        System.out.println(courses);

        List<String> courseList=instructorList.stream().map(Instructor::getCourses).
                flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
        System.out.println(courseList);

        //anyMatch allMatch noneMatch

        Boolean count=instructorList.stream().map(Instructor::getCourses).
                flatMap(List::stream).noneMatch(i->i.startsWith("J"));
        System.out.println(count);
    }
}
