package com.java.datetime;

import java.time.LocalDate;

public class DateTimeExample2 {
    public static void main(String[] args) {

        LocalDate localdate=LocalDate.now();
        //get date 4 days from now

        System.out.println(localdate.plusDays(4));
        System.out.println(localdate);

    }
}
