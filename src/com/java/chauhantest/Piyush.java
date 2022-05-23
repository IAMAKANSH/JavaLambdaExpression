package com.java.chauhantest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Piyush {
    public static void main(String[] args) {
        //Consider f4 list of numbers
        List<Integer> l1= Arrays.asList(1,4,6,7,8,2);
        List<Integer> l2= Arrays.asList(1,3,8,9,8,2);
        List<Integer> l3= Arrays.asList(4,2,6,7,8,1);
        List<Integer> l4= Arrays.asList(1,4,6,7,9,2);
        //Adding list of integer
        List<List<Integer>> list=Arrays.asList(l1,l2,l3,l4);

        //finalList
        List<List<Integer>> finalList=new ArrayList<>();
        //Looping in each list of list<Integer>
        for (List<Integer> numbers:
                list) {
            //sorting the list in natural order
            List<Integer> listSorted=numbers.stream().sorted().collect(Collectors.toList());
            //Adding in the list
            finalList.add(listSorted);
        }
        //Checking the answer
        finalList.forEach(integers -> {
            System.out.println(integers);
        });
    }
}
