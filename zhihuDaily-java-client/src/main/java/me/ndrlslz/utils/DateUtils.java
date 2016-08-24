package me.ndrlslz.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * Get date string with given year, month and day
     *
     * @param year  year
     * @param month month
     * @param day   day
     * @return date string
     */
    public static String getStringWith(int year, int month, int day) {
        return LocalDate.of(year, month, day).format(formatter);
    }

    /**
     * Get date string of today
     *
     * @return date string
     */
    public static String getStringOfNow() {
        return LocalDate.now().format(formatter);
    }

    /**
     * Get the day before given day.
     *
     * @param date date string
     * @return the day before given date
     */
    public static String getDayBefore(String date) {
        LocalDate yesterday = LocalDate.parse(date, formatter);
        return yesterday.minus(1, ChronoUnit.DAYS).format(formatter);
    }

}
