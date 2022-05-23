package com.java.funcprogramming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredicateExample {

    public static void main(String[] args) {

        List<Instructor> instructors=Instructors.getAll();

        BiPredicate<Boolean,Integer> predicate3=(online,experience)->online==true && experience>2;



        BiConsumer<String,List<String>> biConsumer=(name, courses)-> System.out.println(name+" "+courses);

        instructors.forEach(instructor -> {
            if(predicate3.test(instructor.isOnlineCourses(),instructor.getYearOfExperience()))
                biConsumer.accept(instructor.getName(),instructor.getCourses());
        });




    }
}
