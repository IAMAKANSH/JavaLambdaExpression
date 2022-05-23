package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalOperationMapping {

    public static void main(String[] args) {

        //map
        List<String> names= Instructors.getAll().stream().map(Instructor::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
        //mappping
        System.out.println("--------------------");
        List<String> terminalNames=Instructors.getAll().stream().collect(Collectors.mapping(Instructor::getName,Collectors.toList()));
        terminalNames .forEach(System.out::println);
        //downstream operation
        System.out.println("--------------------");
        //Instructors grouping by year of experience
        Map<Integer,List<String>> downStreamNames=Instructors.getAll().stream().collect(Collectors.groupingBy(Instructor::getYearOfExperience,Collectors.mapping(Instructor::getName,Collectors.toList())));
        System.out.println(downStreamNames);;

    }
}
