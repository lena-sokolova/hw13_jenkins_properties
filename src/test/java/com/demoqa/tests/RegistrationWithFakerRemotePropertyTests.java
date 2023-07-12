package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;


public class RegistrationWithFakerRemotePropertyTests extends RemoteTestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @Tag("property")
    void successfulRegistrationTest() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomGender(),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                day = String.valueOf(faker.number().numberBetween(0, 31)),
                month = getRandomMonth(),
                year = String.valueOf(RandomUtils.getRandomInt(1980, 1989)),
                subject = getRandomSubject(),
                hobbies = getRandomHobbies(),
                pictureName = "nature.jpg",
                currentAddress = faker.address().fullAddress(),
                state = getRandomState(),
                city = getRandomCity(state);

        step("Open form", () -> {
            registrationPage
                    .openPage()
                    .closeBanners();
        });

        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthDay(day, month, year)
                    .setSubject(subject)
                    .setHobby(hobbies)
                    .uploadPicture(pictureName)
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .clickSubmitBtn();
        });

        step("Verify results", () -> {
            registrationPage
                    .checkModalDialogVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", pictureName)
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", state + " " + city)
                    .closeTableResponsive();
        });
    }
}
