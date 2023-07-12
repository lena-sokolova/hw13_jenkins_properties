package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;

import static com.demoqa.utils.RandomUtils.*;
import static com.demoqa.utils.RandomUtils.getRandomCity;

public class TestData {
    static Faker faker = new Faker();

    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String userEmail = faker.internet().emailAddress();
    static String gender = getRandomGender();
    static String userNumber = faker.phoneNumber().subscriberNumber(10);
    static String day = String.valueOf(faker.number().numberBetween(0, 31));
    static String month = getRandomMonth();
    static String year = String.valueOf(RandomUtils.getRandomInt(1980, 1989));
    static String subject = getRandomSubject();
    static String hobbies = getRandomHobbies();
    static String pictureName = "nature.jpg";
    static String currentAddress = faker.address().fullAddress();
    static String state = getRandomState();
    static String city = getRandomCity(state);
}
