package com.java.funcprogramming;

import java.util.List;
import java.util.function.IntConsumer;

public class VariableScopeExample {
    static int k=0;
    public static void main(String[] args) {
        //local variable
        int b=10;

        IntConsumer intConsumer=(a)-> System.out.println(a*10);



        List<Instructor> instructor=Instructors.getAll();
        instructor.forEach(instructor1 ->
        {
            System.out.println(instructor1+ " " +k);
        });
        k++;

    }
}
