package com.java.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DurationExample {
    public static void main(String[] args) {

        LocalDateTime localDateTime=LocalDateTime.now();
        LocalDateTime localDateTime1=LocalDateTime.now().plusHours(4);
        Duration duration=Duration.between(localDateTime,localDateTime1);
        System.out.println(duration.toHours());

        duration=Duration.ofHours(3);
        System.out.println(duration.toMinutes());

        //Instant Class
        Instant instant=Instant.now();
        System.out.println(instant.getNano());

        LocalDateTime localDateTime2=LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime2);


    }
}
