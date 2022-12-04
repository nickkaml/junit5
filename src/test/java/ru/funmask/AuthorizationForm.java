package ru.funmask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationForm {

    String email = "test@test.ru";

    @BeforeEach
    void openAuthorizationPage() {
        open("https://fun-mask.ru/my-account/");

    }


    @DisplayName("Wrong password")
    @Test
    void wrongPassword() {

        String password = "12345678";

        $("#username").setValue(email);
        $("#password").setValue(password);
        $(".woocommerce-form-login__submit").click();

        $(".woocommerce-error").shouldHave(text("Пароль"));
    }


    @DisplayName("Right password")
    @Test
    void rightPassword() {

        String password = "test2tesT3";

        $("#username").setValue(email);
        $("#password").setValue(password);
        $(".woocommerce-form-login__submit").click();

        $(".woocommerce-MyAccount-content").shouldHave(text("Добро пожаловать"));
    }

}
