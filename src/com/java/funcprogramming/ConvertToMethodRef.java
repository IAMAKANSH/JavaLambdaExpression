package com.java.funcprogramming;

import java.util.function.Predicate;

public class ConvertToMethodRef {

    public static void main(String[] args) {
       // Predicate<Instructor> predicate=(p)->p.getYearOfExperience()>10;
        Predicate<Instructor> predicate=ConvertToMethodRef::greaterThanTenYearOfExperience;

        Instructors.getAll().forEach(instructor -> {
            if(predicate.test(instructor))
            {
                System.out.println(instructor);
            }
        });
    }

    public static  boolean greaterThanTenYearOfExperience(Instructor instructor)
    {
        return instructor.getYearOfExperience() > 10;
    }


}
