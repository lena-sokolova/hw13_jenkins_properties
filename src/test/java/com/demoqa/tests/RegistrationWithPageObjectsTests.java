package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .closeBanners()
                .setFirstName("Elena")
                .setLastName("Sokolova")
                .setUserEmail("e.sokolova@example.com")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setBirthDay("07", "July", "1989")
                .setSubject("English")
                .setHobby("Sports")
                .uploadPicture("nature.jpg")
                .setCurrentAddress("Some address")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .clickSubmitBtn();

        registrationPage
                .checkModalDialogVisible()
                .checkResult("Student Name","Elena Sokolova")
                .checkResult("Student Email", "e.sokolova@example.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "07 July,1989")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "nature.jpg")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "Rajasthan Jaipur")
                .closeTableResponsive();

    }
}
