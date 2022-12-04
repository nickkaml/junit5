package ru.ozon;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AgeVerification {

    @BeforeEach
    void openAgeVerificationPage() {

        //Открываем на Ozon товар 18+ из категории "Табак"
        open("https://www.ozon.ru/product/komplekt-iqos-3-duos-siniy-161683849/");

    }

    @DisplayName("Checking the date is strongly in the past")
    @Tag("Низкий")
    @Test
    void birthdayInThePastTest() {

        String birthdate = "01.01.1022";

        $("input[name='birthdate']").setValue(birthdate);
        $(byText("Подтвердить")).click();

        $("#layoutPage").shouldHave(text(
                "Указанная дата рождения должна быть не ранее чем 100 лет назад и меньше сегодняшней даты"));

    }


    @Disabled("Interfering with captcha entry")
    @DisplayName("Checking the date is strongly in the future")
    @Tag("Низкий")
    @Test
    void birthdayInTheFutureTest() {

        String birthdate = "01.01.3022";

        $("input[name='birthdate']").setValue(birthdate);
        $(byText("Подтвердить")).click();

        $("#layoutPage").shouldHave(text(
                "Указанная дата рождения должна быть не ранее чем 100 лет назад и меньше сегодняшней даты"));

    }
}
