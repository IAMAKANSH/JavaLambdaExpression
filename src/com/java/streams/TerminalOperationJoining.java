package com.java.streams;

import com.java.funcprogramming.Instructor;
import com.java.funcprogramming.Instructors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationJoining {

    public static void main(String[] args) {

        //a,b,c,d,e,f

        String result=Stream.of("A","B","D","E").collect(Collectors.joining());
        System.out.println(result);

        String result1=Stream.of("A","B","D","E").collect(Collectors.joining(","));
        System.out.println(result1);

        String result2=Stream.of("A","B","D","E").collect(Collectors.joining(",","\"","\""));
        System.out.println(result2);

        //instructors names separted by ' and prefix { and suffix }

        String ins=Instructors.getAll().stream().map(Instructor::getName).collect(Collectors.joining(",","{","}"));
        System.out.println(ins);
    }
}
