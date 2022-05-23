package com.java.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultsExample {

    public static void main(String[] args) {

        List<String> names= Arrays.asList("Akash","Mike","Janny","Marvel","Khabib");
//        Collections.sort(names);
//        System.out.println("names ="+names);

        names.sort(Comparator.naturalOrder());
        System.out.println("names=="+names);

    }
}
