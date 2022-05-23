package com.java.chauhantest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatIssue {
    public static void main(String[] args) {


        String duration="10 hour, 1 minutes and 22 seconds.";
        //for hour ([0-9]*) hour,
        //for minute ([0-9]*) (minute|minutes)* (and)*
        //for seconds ([0-9]*) seconds.
        //[([0-9]*) (minute|minutes)\s]*(\sand\s)*([0-9]*\sseconds.)
        Pattern p=Pattern.compile("([0-9]*) hour,");
        Matcher m = p.matcher(duration);
        if(m.find())
        {
            System.out.println(m.group(1));
        }
        else
        {
            System.out.println("Not found");
        }

        String fail="16,416";
        try{
           int a= Integer.parseInt(fail.replaceAll(",",""));
            System.out.println(a);
        }catch (Exception e)
        {
            System.out.println("Could not parse "+e.getMessage());
        }



    }
}
