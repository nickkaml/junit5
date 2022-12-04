package ru.funmask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationForm {

    String email = "test@test.ru";


    @DisplayName("Wrong password")
    @Test
    void wrongPassword() {
        open("https://fun-mask.ru/my-account/");
        //Configuration.holdBrowserOpen = true;

        String password = "12345678";

        $("#username").setValue(email);
        $("#password").setValue(password);
        $(".woocommerce-form-login__submit").click();

        $(".woocommerce-notices-wrapper").shouldHave(text("Ошибка"));
    }

    @DisplayName("Right password")
    @Test
    void rightPassword() {
        open("https://fun-mask.ru/my-account/");
        //Configuration.holdBrowserOpen = true;

        String password = "test2tesT3";

        $("#username").setValue(email);
        $("#password").setValue(password);
        $(".woocommerce-form-login__submit").click();

        $(".woocommerce-notices-wrapper").shouldNotHave(text("Ошибка"));
    }

}
