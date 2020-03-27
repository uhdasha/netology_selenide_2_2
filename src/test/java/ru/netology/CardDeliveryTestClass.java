package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Keys;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardDeliveryTestClass {
    @Test
    @DisplayName("Testing delivery card form")
    public void makeTestFillForm() {
        open("http://127.0.0.1:9999");
        $("[data-test-id='city']").find("input").setValue("Казань");

        $("[data-test-id='date']").find("input").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("[data-test-id='date']").find("input").sendKeys("\b");

        DateGenerator date = new DateGenerator();
        date.doGenerateDateString();
        $("[data-test-id='date']").find("input").val(date.getDate());

        $("[data-test-id='name']").find("input").setValue("Петр Первый");
        $("[data-test-id='phone']").find("input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button_view_extra").click();

        $("[data-test-id='notification']").waitWhile(hidden, 15000).find(".notification__title").shouldHave(text("Успешно!"));

    }

}