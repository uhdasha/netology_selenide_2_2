package ru.netology;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class DateGenerator {
    private String formatedDate;

    public void do_genarate_date_string() {
        Calendar date = new GregorianCalendar();

        Random random = new Random();
        date.add(Calendar.DAY_OF_MONTH, random.nextInt(31) + 3);
        String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
        if (date.get(Calendar.DAY_OF_MONTH) < 10) {
            day = "0" + day;
        }
        String mon = String.valueOf(date.get(Calendar.MONTH) + 1);
        if (date.get(Calendar.MONTH) + 1 < 10) {
            mon = "0" + mon;
        }

        this.formatedDate = day + "." + mon + "." + date.get(Calendar.YEAR);
    }

    public String getDate() {
        return this.formatedDate;
    }
}
