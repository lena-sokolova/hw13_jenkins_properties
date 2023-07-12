package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class RegistrationWithFakerRemotePropertyTests extends RemoteTestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @Tag("property")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {

        step("Open form", () -> {
            registrationPage
                    .openPage()
                    .closeBanners();
        });
        step("Fill form", () -> {
            registrationPage
                    .setFirstName(TestData.firstName)
                    .setLastName(TestData.lastName)
                    .setUserEmail(TestData.userEmail)
                    .setGender(TestData.gender)
                    .setUserNumber(TestData.userNumber)
                    .setBirthDay(TestData.day, TestData.month, TestData.year)
                    .setSubject(TestData.subject)
                    .setHobby(TestData.hobbies)
                    .uploadPicture(TestData.pictureName)
                    .setCurrentAddress(TestData.currentAddress)
                    .setState(TestData.state)
                    .setCity(TestData.city)
                    .clickSubmitBtn();
        });
        step("Verify results", () -> {
            registrationPage
                    .checkModalDialogVisible()
                    .checkResult("Student Name", TestData.firstName + " " + TestData.lastName)
                    .checkResult("Student Email", TestData.userEmail)
                    .checkResult("Gender", TestData.gender)
                    .checkResult("Mobile", TestData.userNumber)
                    .checkResult("Date of Birth", TestData.day + " " + TestData.month + "," + TestData.year)
                    .checkResult("Subjects", TestData.subject)
                    .checkResult("Hobbies", TestData.hobbies)
                    .checkResult("Picture", TestData.pictureName)
                    .checkResult("Address", TestData.currentAddress)
                    .checkResult("State and City", TestData.state + " " + TestData.city);
//                    .closeTableResponsive();
        });
    }
}
