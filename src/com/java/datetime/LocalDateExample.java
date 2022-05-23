package com.java.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateExample {

    public static void main(String[] args) {

        //creating localdate

        LocalDate now=LocalDate.now();
        System.out.println(now);

        //using day of the year

        now=LocalDate.ofYearDay(2021,35);
        System.out.println(now);

        now=LocalDate.of(2020,05,23);
        System.out.println(now);

        //get methods
        System.out.println(LocalDate.now().getMonth());
        System.out.println(LocalDate.now().get(ChronoField.DAY_OF_MONTH));
    }
}
