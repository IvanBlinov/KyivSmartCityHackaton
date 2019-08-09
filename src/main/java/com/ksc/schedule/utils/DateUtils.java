package com.ksc.schedule.utils;

import java.util.Date;

public class DateUtils {

    public static String getCurrentTime() {
        Date currentDate = new Date();
        return currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();
    }
}
