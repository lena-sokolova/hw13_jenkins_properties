package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    SelenideElement
        userNameInput = $("#userName"),
        userEmailInput = $("#userEmail"),
        currentAddressInput = $("#currentAddress"),
        permanentAddressInput = $("#permanentAddress"),
        submitBtn = $("#submit"),
        outputName = $("#output #name"),
        outputEmail = $("#output #email"),
        outputCurrentAddress = $("#output #currentAddress"),
        outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open ("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public TextBoxPage setUserName (String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress (String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage clickSubmitBtn() {
        submitBtn.click();

        return this;
    }

    public void verifyResult(String name, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(name));
        outputEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddress));
        outputPermanentAddress.shouldHave(text(permanentAddress));
    }
}
