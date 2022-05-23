package com.java.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateTimeExample {

    public static void main(String[] args) {

        //Date and simpledateformatter

        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(date));

        dateFormat=new SimpleDateFormat("HH:mm:ss");
        System.out.println(dateFormat.format(date));

        System.out.println(Calendar.getInstance().getTime());

        //new data library introduced

        LocalDate now=LocalDate.now();
        System.out.println(now);

        //LocalTime

        LocalTime time=LocalTime.now();
        System.out.println(time);

        //LocalDateTime

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime );
    }
}
