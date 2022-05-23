package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalGroupingByPart2Example {

    public static void main(String[] args) {

      //groupingBy(classifier,mapfactory,downstream)
        //groupingBy(classifier,downstream)
        List<String> namesList= Arrays.asList("Sanjeev","Nihari","James","Rahul","Preeti","Adi");

        //grouping length of the string and also checking that names contains  e and only return those names which have e
        LinkedHashMap<Integer, List<String>> result5=namesList.stream().collect(Collectors.groupingBy(
                String::length, LinkedHashMap::new,Collectors.filtering(s->s.contains("e"),Collectors.toList())
        ));
        result5.forEach((key,value)->{
            System.out.println(key+"="+value);
        });

        //grouping them by senior and junior senior>10 and filter them online courses
        LinkedHashMap<String,List<Instructor>> result6= Instructors.getAll().stream().collect(Collectors.groupingBy(instructor ->

                instructor.getYearOfExperience()>10?"Senior":"Junior",LinkedHashMap::new,Collectors.filtering(instructor -> instructor.isOnlineCourses(),Collectors.toList())
        ));

        result6.forEach((key,value)->{
            System.out.println(key+"="+value);
        });

    }
}
