package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.RegistrationResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    String formTitle = "Student Registration Form";
    String successRegistrationFormText = "Thanks for submitting the form";


    CalendarComponent calendarComponent = new CalendarComponent();

    SelenideElement
            practiceFormWrapper = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadFileBtn = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            submitBtn = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalDialogTitle = $("#example-modal-sizes-title-lg");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text(formTitle));

        return this;
    }

    public RegistrationPage closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        ;

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        ;

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadFileBtn.uploadFromClasspath(value);
        ;

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitBtn() {
        submitBtn.click();

        return this;
    }

    public RegistrationPage checkModalDialogVisible() {
        modalDialog.should(appear);
        modalDialogTitle.shouldHave(text(successRegistrationFormText));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        RegistrationResultComponent.verifyResult(key, value);

        return this;
    }

    public RegistrationPage closeTableResponsive() {
        RegistrationResultComponent.clickCloseBtn();

        return this;
    }
}



