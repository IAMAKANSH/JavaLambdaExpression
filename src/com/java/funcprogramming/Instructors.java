package com.java.funcprogramming;

import java.util.Arrays;
import java.util.List;

public class Instructors {

    public static List<Instructor> getAll(){
        Instructor instructor=new Instructor("Mike",10,"Software Developer","Male",
                true, Arrays.asList("Java Programming","AWS Cloud","Azure"));
        Instructor instructor2=new Instructor("Jenny",5,"System Engineer","Female",
                false, Arrays.asList("MultiThreading Programming","CI/CD","Unit Testing"));
        Instructor instructor3=new Instructor("Jake",6,"Manager","Male",
                false, Arrays.asList("Devops","Excel","Scrum/Agile"));
        Instructor instructor4=new Instructor("Akash",2,"Specialist Programmer","Male",
                true, Arrays.asList("Java/Spring boot","AWS Cloud","Spark"));
        Instructor instructor5=new Instructor("Richard",12,"Technology Lead","Male",
                true, Arrays.asList("Spring Boot /Microservices","MuleSoft","AWS"));
        List<Instructor> list=Arrays.asList(instructor,instructor2,instructor3,instructor4,instructor5);
        return list;
    }
}
