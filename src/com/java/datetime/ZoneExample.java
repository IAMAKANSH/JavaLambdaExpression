package com.java.datetime;

import java.time.*;
import java.util.Date;

public class ZoneExample {
    public static void main(String[] args) {

        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
        System.out.println("Asia/Aden  "+ ZonedDateTime.now(ZoneId.of("Asia/Aden")));
        //Convert to zonedDateTime

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime=localDateTime.atZone(ZoneId.of("Asia/Aden"));
        System.out.println(zonedDateTime);
        System.out.println(localDateTime.atOffset(ZoneOffset.ofHours(-10)));

        //convert sql date to localdate
        Date date=new Date();
        LocalDateTime localDateTime1=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime1);

        java.sql.Date date1=new java.sql.Date(System.currentTimeMillis());
        LocalDate localDate=date1.toLocalDate();
        System.out.println(localDate);
    }
}
