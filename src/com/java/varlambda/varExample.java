package com.java.varlambda;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class varExample {

    public static void main(String[] args) {
        //instead for List<Instructor> we can use var because
        var instructors= Instructors.getAll();

        Predicate<Instructor> predicate=(var s)->s.getYearOfExperience()>10;

        instructors.forEach(instructor -> {
            if(predicate.test(instructor))
            {
                var result=instructor.getName();
                System.out.println(result);
            }
        });

        BiFunction<Integer,Integer,Integer> sum=(var x,var y)->x+y;
        System.out.println(sum.apply(10,20));

    }
}
