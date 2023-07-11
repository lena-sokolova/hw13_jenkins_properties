package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;


public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker();
//        Faker faker = new Faker(new Locale("ru"));

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

        registrationPage.openPage()
                .closeBanners()
                .setFirstName(firstName)
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
    }
}
