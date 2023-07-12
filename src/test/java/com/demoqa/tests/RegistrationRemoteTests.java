package com.demoqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class RegistrationRemoteTests extends RemoteTestBase {

    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {
        step("Open form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Elena");
            $("#lastName").setValue("Sokolova");
            $("#userEmail").setValue("e.sokolova@example.com");
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("1989");
            $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("English").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("nature.jpg");
            $("#currentAddress").setValue("Some address");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Rajasthan")).click();
            $("#city").click();
            $("#city").$(byText("Jaipur")).click();
            $("#submit").click();
        });
        step("Verify results", () -> {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Elena"), text("Sokolova"),
                    text("e.sokolova@example.com"), text("1234567890"), text("07 July,1989"), text("English"),
                    text("Sports"), text("nature.jpg"),
                    text("Some address"), text("Rajasthan Jaipur"));
        });
    }
}
