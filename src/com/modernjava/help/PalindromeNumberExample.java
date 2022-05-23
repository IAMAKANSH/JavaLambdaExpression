package com.modernjava.help;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromeNumberExample {

    public static void main(String[] args) {
        List<Integer> palindromeList=new ArrayList<>();
        Function<Integer,Boolean> integerBooleanFunction=(a)->{
            int sum=0;
            int actualNum=a;
            while(a!=0)
            {
                int rev=a%10;
                sum=sum*10+rev;
                a=a/10;
            }
            return actualNum==sum?true:false;
        };
        for (int i=10;i<100;i++)
        {
            if(integerBooleanFunction.apply(i))
            {
                palindromeList.add(i);
            }
        }

        System.out.println("Reverse order palindrom list from 10-100 is "+palindromeList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

    }
}
