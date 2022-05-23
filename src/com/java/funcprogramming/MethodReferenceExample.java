package com.java.funcprogramming;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {

    public static void main(String[] args) {

        Predicate<Instructor> predicate=(i)->i.isOnlineCourses();
        Predicate<Instructor> predicate1=Instructor::isOnlineCourses;

        Function<Integer,Double> doubleFunction=n->Math.sqrt(n);
        Function<Integer,Double> doubleFunction1=Math::sqrt;

        Function<String,String> lowerCaseFunction=s1->s1.toLowerCase();
        Function<String,String> lowerCaseFunction1=String::toLowerCase;

    }
}
