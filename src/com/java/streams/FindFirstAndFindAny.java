package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstAndFindAny {

    public static void main(String[] args) {

        List<Integer> integerList= Arrays.asList(1,2,4,7,8,9,3);
        //Usually give first index from the list
        Optional findAnyElement=integerList.stream().findAny();

        Optional findFirstOptional=integerList.stream().findFirst();
        System.out.println(findFirstOptional.get());

    }
}
