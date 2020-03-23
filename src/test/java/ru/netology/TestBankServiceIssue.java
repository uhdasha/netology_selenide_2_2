package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Keys;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestBankServiceIssue {
    @Test
    @DisplayName("Testing delivery card form")
    public void test_issue_card() {
        open("http://127.0.0.1:9999");
        $("[data-test-id='city']").find("input").setValue("Казань");

        $("[data-test-id='date']").find("input").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("[data-test-id='date']").find("input").sendKeys("\b");
        $("[data-test-id='date']").find("input").val(genarate_date_string());

        $("[data-test-id='name']").find("input").setValue("Петр Первый");
        $("[data-test-id='phone']").find("input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button_view_extra").click();

        $("[data-test-id='notification']").waitWhile(hidden, 15000).find(".notification__title").shouldHave(text("Успешно!"));

    }

    private String genarate_date_string() {
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
        String dateStr = day + "." + mon + "." + date.get(Calendar.YEAR);
        return dateStr;
    }
}