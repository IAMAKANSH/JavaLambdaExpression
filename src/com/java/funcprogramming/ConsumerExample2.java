package com.java.funcprogramming;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors=Instructors.getAll();

        //looping through all the instructor sand printing  out the values of instructor
        Consumer<Instructor> consumer=(s1)-> System.out.println(s1);
        instructors.forEach(consumer);

        //looping through all the instructor and print only name

        Consumer<Instructor> c2=(s1)-> System.out.println(s1.getName());
        instructors.forEach(c2);

        //loop through all the instructors and print out their names and their courses
        Consumer<Instructor> c3=(s1)-> System.out.println(s1.getCourses());
        instructors.forEach(c2.andThen(c3));

        //loop through all the instructor and print out their name if years are >10

        instructors.forEach(instructor -> {
            if(instructor.yearOfExperience>10)
                consumer.accept(instructor);
        });

        //loop through all the instructor and print out their name and year of experience if year of experience >5
        //and teaches courses online
        System.out.println("-------------------");
        instructors.forEach(s1->{
            if(s1.yearOfExperience>5 && !s1.isOnlineCourses())
            {
                consumer.andThen(c2).accept(s1);
            }
        });
    }
}
