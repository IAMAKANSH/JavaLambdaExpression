package com.java.chauhantest;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

     List<Integer> list1=Arrays.asList(4,7,8,9,12,49,4,32,78,90,99,33,10);
     List<Integer> list2=Arrays.asList(2,4,90,77,23,45,99,69,77,55,82,44,7);
     List<Integer> list3=new ArrayList<>();
     Long start=System.currentTimeMillis();
     System.out.println(start);
     for (int i=0;i<list1.size();i++)
     {
         for(int j=0;j< list2.size();j++)
         {
             if(list1.get(i)== list2.get(j))
             {
                 list3.add(list2.get(j));
             }
         }
     }
     Long end=System.currentTimeMillis();
     System.out.println(end);
     System.out.println(list3);
     System.out.println(end-start+10+" ::Total time take");
        Predicate<Integer> predicate=integer -> list2.contains(integer);
        Long startStream=System.currentTimeMillis();
        System.out.println(startStream);
     List<Integer> list4=list1.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(list4);
     Long endTime=System.currentTimeMillis();
        System.out.println(endTime);
        System.out.println(endTime-startStream+10+ "::Total time");
    }
}
