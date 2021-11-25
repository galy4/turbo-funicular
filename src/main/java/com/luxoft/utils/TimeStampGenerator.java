package com.luxoft.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeStampGenerator {

    public static String getCurrentTimeStamp(){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        return ft.format(new Date());
    }

    public static String getDepartureDate(int delta){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss+06:00");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -delta);
        return ft.format(new Date(calendar.getTimeInMillis()));
    }

    public static String generateTimeStampNODelimeters(){
        SimpleDateFormat ft = new SimpleDateFormat("ddMMyyhhmmss");
        return ft.format(new Date());
    }

    public static String getCurrentDate(){
        SimpleDateFormat ft = new SimpleDateFormat("ddMMyy");
        return ft.format(new Date());
    }

    public static String getDepartureDateWithMs(int delta){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+06:00");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -delta);
        return ft.format(new Date(calendar.getTimeInMillis()));
    }
}

