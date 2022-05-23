package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingMinMaxAverageExample {

    public static void main(String[] args) {
        //Grouping the instructor into two set of online courses vs not online courses
        //and get the max year of experience

        Map<Boolean, Optional<Instructor>> booleanOptionalMap= Instructors.getAll().stream().collect(Collectors.groupingBy(
                Instructor::isOnlineCourses,Collectors.maxBy(Comparator.comparing(Instructor::getYearOfExperience))
        ));
        booleanOptionalMap.forEach((aBoolean, instructor) -> {
            System.out.println(aBoolean+"=="+instructor);
        });

        //collectingAndThen


        Map<Boolean, Instructor> booleanOptionalMa1p= Instructors.getAll().stream().collect(Collectors.groupingBy(
                Instructor::isOnlineCourses,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Instructor::getYearOfExperience)),
                        Optional::get)));
        booleanOptionalMa1p.forEach((aBoolean, instructor) -> {
            System.out.println(aBoolean+"=="+instructor);
        });

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
        //average year of experience who teaches online or not

        Map<Boolean, Double> map= Instructors.getAll().stream().collect(Collectors.groupingBy(
                Instructor::isOnlineCourses,Collectors.averagingInt(Instructor::getYearOfExperience)
                       ));
        map.forEach((aBoolean, instructor) -> {
            System.out.println(aBoolean+"=="+instructor);
        });


        ///statistical  summary from properties of grouped items

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");

        Map<Boolean, IntSummaryStatistics> map2= Instructors.getAll().stream().collect(Collectors.groupingBy(
                Instructor::isOnlineCourses,Collectors.summarizingInt(Instructor::getYearOfExperience)
        ));
        map2.forEach((aBoolean, instructor) -> {
            System.out.println(aBoolean+"=="+instructor);
        });


    }
}
