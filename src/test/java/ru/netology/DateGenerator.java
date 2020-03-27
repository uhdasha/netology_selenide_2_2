package ru.netology;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class DateGenerator {
    private String formatedDate;

    public void doGenerateDateString() {
        Calendar date = new GregorianCalendar();

        Random random = new Random();
        // добавляем от текущей даты, т.е. если было 28 февраля то add(5)
        // выдаст результирующую дату 04 марта
        // + 3 - это минимально возможное случайное число, которое добавляем к текущей дате
        date.add(Calendar.DAY_OF_MONTH, random.nextInt(10) + 3);
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
