package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitionExample {

    public static void main(String[] args) {

        //partition instructors in two groups of instructor

        //first is year of experience >10 and other is <10

        Predicate<Instructor> predicate=instructor -> instructor.getYearOfExperience()>10;

        Map<Boolean, List<Instructor>> partitionMap= Instructors.getAll().stream().collect(Collectors.partitioningBy(
                predicate
        ));

        partitionMap.forEach((aBoolean, instructors) ->
                System.out.println(aBoolean+"=="+instructors));

        //partition but return is set instead of list

        Map<Boolean, Set<Instructor>> map=Instructors.getAll().stream().collect(Collectors.partitioningBy(predicate,Collectors.toSet()));
        map.forEach((aBoolean, instructors) ->
                System.out.println(aBoolean+"==="+instructors));
    }
}
