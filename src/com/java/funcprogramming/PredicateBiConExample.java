package com.java.funcprogramming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateBiConExample {

    public static void main(String[] args) {

        List<Instructor> instructors=Instructors.getAll();
        Predicate<Instructor> predicate=(i)->i.isOnlineCourses()==true;

        Predicate<Instructor> predicate2=(i)->i.getYearOfExperience()>2;

        BiConsumer<String,List<String>> biConsumer=(name,courses)-> System.out.println(name+" "+courses);

        instructors.forEach(instructor -> {
            if(predicate.and(predicate2).test(instructor))
                biConsumer.accept(instructor.getName(),instructor.getCourses());
        });

    }
}
