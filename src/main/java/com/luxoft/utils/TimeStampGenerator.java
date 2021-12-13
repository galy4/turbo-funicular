package com.luxoft.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TimeStampGenerator {

    public static String getCurrentTimeStamp(){
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return ft.format(ZonedDateTime.now());
    }

    public static String getDepartureDate(int delta){
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss x:00");
        ZonedDateTime date = ZonedDateTime.now().minusDays(delta);
        return ft.format(date);
    }

    public static String generateTimeStampNODelimeters(){
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        return ft.format(ZonedDateTime.now());
    }

    public static String getCurrentDate(){
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("ddMMyy");
        return ft.format(ZonedDateTime.now());
    }

    public static String getDepartureDateWithMs(int delta){
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS x:00");
        ZonedDateTime date = ZonedDateTime.now().minusDays(delta);
        return ft.format(date);
    }
}

