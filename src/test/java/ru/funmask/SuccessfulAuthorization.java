package ru.funmask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SuccessfulAuthorization {

    @ParameterizedTest
    @CsvSource({
            "test@test.ru, test2tesT3",
            "test@test.ru, test2tesT3",
            "test@test.ru, test2tesT3",
            "test@test.ru, test2tesT3"
    })
    void testWithCsvSource(String email, String password) {
        open("https://fun-mask.ru/my-account/");
        $("#username").setValue(email);
        $("#password").setValue(password);
        $(".woocommerce-form-login__submit").click();

        $(".woocommerce-MyAccount-content").shouldHave(text("Добро пожаловать" + email));
    }

}
