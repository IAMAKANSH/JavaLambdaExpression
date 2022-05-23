package com.java.funcprogramming;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample2 {

    public static void main(String[] args) {

        //all instructors who teaches online
        Predicate<Instructor> predicate=(i)->i.isOnlineCourses()==true;
        //all instructor who has experience greater than 2
        Predicate<Instructor> predicate1=(i)->i.getYearOfExperience()>2;

        List<Instructor> instructors=Instructors.getAll();

        instructors.forEach(instructor -> {
            if(predicate.test(instructor))
                System.out.println(instructor);
        });
        System.out.println("-----------space between two predicate--------------");
        instructors.forEach(instructor -> {
            if (predicate1.test(instructor)) {
                System.out.println(instructor);
            }
        });
    }
}
