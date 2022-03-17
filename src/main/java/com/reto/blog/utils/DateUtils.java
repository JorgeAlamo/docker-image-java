package com.reto.blog.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public static int calculateAge(Date date) {
        String [] dateValues = date.toString().split("-");

        return Period.
                between(LocalDate.of(
                            Integer.parseInt(dateValues[0]),
                            Integer.parseInt(dateValues[1]),
                            Integer.parseInt(dateValues[2])),
                        LocalDate.now())
                .getYears();
    }

    public static boolean isSameDay(Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        return fmt.format(date1)
                .equals(fmt.format(date2));
    }

}
