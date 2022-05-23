package com.java.funcprogramming;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample2 {

    public static void main(String[] args) {


        List<Instructor> instructors=Instructors.getAll();

        //print out name and gender of an instructor

        BiConsumer<String,String> biConsumer=(name,gender)-> System.out.println(name+" "+gender);
        instructors.forEach(instructor -> {
            biConsumer.accept(instructor.getName(),instructor.getGender());
        });


        //print out name and list of courses

        BiConsumer<String,List<String>> biConsumer1=(name,courses)-> System.out.println("Name is "+name+"  list of courses are "+courses);

        instructors.forEach(instructor -> {
            biConsumer1.accept(instructor.getName(),instructor.getCourses());
        });

        //print out name and gender of all the instructor who teaches online

        System.out.println("--------------------------");
        instructors.forEach(instructor -> {
            if(instructor.isOnlineCourses())
                biConsumer.accept(instructor.getName(),instructor.gender);
        });
    }

}
