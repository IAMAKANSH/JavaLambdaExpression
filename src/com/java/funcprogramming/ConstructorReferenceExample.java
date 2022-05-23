package com.java.funcprogramming;

import java.util.Arrays;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        InstructorFactory instructorFactory=Instructor::new;
        Instructor instructor=instructorFactory.getInstructor("Akansh",20,"Software Dev","Male"
        ,true, Arrays.asList("Java","Cloud"));

        System.out.println(instructor);
    }
}
