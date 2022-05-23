package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMinByMaxBy {

    public static void main(String[] args) {

        //minBy and maxBy

        Optional<Instructor> instructor=Instructors.getAll().stream().collect(Collectors.minBy(Comparator.comparing(Instructor::getYearOfExperience)));
        System.out.println(instructor.get());

        Optional<Instructor> maxInstructor=Instructors.getAll().stream().collect(Collectors.maxBy(Comparator.comparing(
                Instructor::getYearOfExperience
        )));
        System.out.println(maxInstructor.get());
    }
}
