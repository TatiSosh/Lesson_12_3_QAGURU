package com.github.tatisosh;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {
    @BeforeAll
    static void openBrowserFullSize() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void assertTest (){
        open("https://demoqa.com/automation-practice-form");
        $("#app").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Pirogov");
        $("#userEmail").setValue("test@mail.ru");
        $$(".custom-radio").get(1).click();
        $("#userNumber").setValue("79300000777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("chemistry").pressEnter();
        $$(".custom-checkbox").get(1).click();
        $$(".custom-checkbox").get(2).click();
        $("input#uploadPicture").uploadFromClasspath("pozitivnye_kartinki_2.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $(".btn-primary").click();
        $(".modal-body").shouldHave(text("Igor Pirogov"),text("test@mail.ru"),
                text("23 May,1995"),text("chemistry"),text("pozitivnye_kartinki_2.jpg"),
                text("Moscow"),text("Haryana Panipat"));
          }
}
