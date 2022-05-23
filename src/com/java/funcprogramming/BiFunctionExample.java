package com.java.funcprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class BiFunctionExample {

    public static void main(String[] args) {

        //Bifunction two argument one predicate and List<Instructor>

        Predicate<Instructor> predicate=(i)->i.isOnlineCourses()==true;
        //Map of instructors with name and years of experience

        //Function which will take list of instructors as argument and return Map<String,Integer>

        BiFunction<List<Instructor>,Predicate<Instructor>, Map<String,Integer>> mapFunction=((instructors,instructorPredicate)  -> {
            Map<String,Integer> map=new HashMap<>();
            instructors.forEach(instructor -> {
                if(instructorPredicate.test(instructor)) {
                    map.put(instructor.getName(),instructor.getYearOfExperience());
                }
            });
            return map;
        });
        System.out.println(mapFunction.apply(Instructors.getAll(),predicate));


    }
}
