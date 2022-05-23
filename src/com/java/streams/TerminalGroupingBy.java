package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalGroupingBy {

    public static void main(String[] args) {

        //groupingBy(Classifier)
        List<String> names= Arrays.asList("Akansh","Nihari","James","Rahul","Pra","Adi");

         Map<Integer,List<String>> result=names.stream().collect(Collectors.groupingBy(String::length));
        result.forEach((key,value)->{
            System.out.println(key+"="+value);
        });

        System.out.println("----------------");
        Map<String,List<Instructor>> result1=Instructors.getAll().stream().collect(Collectors.groupingBy(Instructor::getGender));
        result1.forEach((key,value)->{
            System.out.println(key+"="+value);
        });

        //grouping by experience where >10 yr of experience is classified
        //as Senior otherwise junior

        Map<String,List<Instructor>> result2=Instructors.getAll().stream().collect(Collectors.groupingBy(instructor ->
        {
            return instructor.getYearOfExperience()>10?"Senior":"Junior";
        }));
        result2.forEach((key,value)->{
            System.out.println(key+"="+value);
        });
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //groupingBy(classifier,downstream)
        List<String> namesList= Arrays.asList("Sanjeev","Nihari","James","Rahul","Preeti","Adi");

        //grouping length of the string and also checking that names contains  e and only return those names which have e
        Map<Integer,List<String>> result5=namesList.stream().collect(Collectors.groupingBy(
                String::length,Collectors.filtering(s->s.contains("e"),Collectors.toList())
        ));
        result5.forEach((key,value)->{
            System.out.println(key+"="+value);
        });

        //grouping them by senior and junior senior>10 and filter them online courses
        Map<String,List<Instructor>> result6=Instructors.getAll().stream().collect(Collectors.groupingBy(instructor ->

            instructor.getYearOfExperience()>10?"Senior":"Junior",Collectors.filtering(instructor -> instructor.isOnlineCourses(),Collectors.toList())
        ));

        result6.forEach((key,value)->{
            System.out.println(key+"="+value);
        });


    }
}
