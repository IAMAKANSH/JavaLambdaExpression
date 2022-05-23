package com.java.chauhantest;

import java.util.*;
import java.util.stream.Collectors;

public class DiskAnalysis {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("The Number of computers are ");
        Integer computer=sc.nextInt();
        int[] arr=new int[computer];
        for (int i=0;i<computer;i++)
        {
            arr[i]=sc.nextInt();
        }
        int segment=sc.nextInt();
        Integer seg=segment(segment,arr);
        System.out.println(seg);

    }

    private static Integer segment(int segment, int[] arr) {

       List<List<Integer>> list=new ArrayList<>();

        for (int i = 0; i <= arr.length - segment; i++) {
            List<Integer> subArr = new ArrayList<>();
            for (int j = i; j < segment + i; j++) {
                subArr.add(arr[j]);
            }
            list.add(subArr);
        }
        System.out.println(list);
        List<Integer> minSeg=list.stream().map(i ->{
            int min=200000;
            for (int j=0;j<i.size();j++)
            {
                if(min>i.get(j))
                {
                    min=i.get(j);
                }
            }
           return min;
        } ).collect(Collectors.toList());
        System.out.println(minSeg);
        Optional<Integer> maxVal=minSeg.stream().max(Comparator.comparing(Integer::intValue));
    return maxVal.get();
    }
}
