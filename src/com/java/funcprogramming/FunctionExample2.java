package com.java.funcprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample2 {

    public static void main(String[] args) {

        Predicate<Instructor> predicate=(i)->i.isOnlineCourses()==true;
        //Map of instructors with name and years of experience

        //Function which will take list of instructors as argument and return Map<String,Integer>

        Function<List<Instructor>, Map<String,Integer>> mapFunction=(instructors -> {
            Map<String,Integer> map=new HashMap<>();
           instructors.forEach(instructor -> {
               if(predicate.test(instructor)) {
                   map.put(instructor.getName(),instructor.getYearOfExperience());
               }
           });
           return map;
        });
        System.out.println(mapFunction.apply(Instructors.getAll()));
    }
}
