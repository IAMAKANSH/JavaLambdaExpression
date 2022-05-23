package com.java.chauhantest;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {

        String number="OR 1- Monitoring";
        ParsePosition pos=new ParsePosition(3);
        Number num=NumberFormat.getInstance().parse(number,pos);
        System.out.println(num.intValue());

    }
    private static String ConvertSecondToHHMMSSString(int nSecondTime) {
        GregorianCalendar cal = new GregorianCalendar(0,0,0,0,0,nSecondTime);
        Date dNow = cal.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("HH 'hours,' mm 'minutes and' ss 'seconds'");
        return ft.format(dNow);
    }
}
