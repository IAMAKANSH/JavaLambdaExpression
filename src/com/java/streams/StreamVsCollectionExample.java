package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollectionExample {

    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("Mike");
        names.add("Sanjay");
        names.add("Mukesh");
        System.out.println("--------------");
        System.out.println(names);

        names.remove("Mike");
        System.out.println("--------------");
        System.out.println(names);

        for (String name:names)
        {
            System.out.println(name);
        }
        Stream<String> nameStream=names.stream();
        nameStream.forEach(System.out::println);


    }
}
