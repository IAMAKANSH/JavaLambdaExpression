package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.List;
import java.util.Optional;

public class StreamReduceExample2 {

    public static void main(String[] args) {
        //printing the instructors who has the highest year of experience

        List<Instructor> instructorList= Instructors.getAll();
        Optional instructor=instructorList.stream().reduce((s1, s2)->{
           if(s1.getYearOfExperience()>s2.getYearOfExperience())
               return s1;
           else
               return s2;
        });
        if (instructor.isPresent())
            System.out.println(instructor.get());

        Optional insOptional=instructorList.stream().reduce((s1,s2)->s2.getYearOfExperience()>s1.getYearOfExperience()
        ?s2:s1);
        if (insOptional.isPresent())
            System.out.println(insOptional.get());
    }
}
