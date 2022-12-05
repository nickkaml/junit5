import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SuccessfulAuthorization {

    @ParameterizedTest(name = "Пользователь {0} успешно авторизуется")
    @CsvSource({
            "test1@test.ru, test1tesT3",
            "test2@test.ru, test2tesT3",
            "test3@test.ru, test3tesT3",
            "test4@test.ru, test4tesT3"
    })
    void testWithCsvSource(String email, String password) {
        open("https://fun-mask.ru/my-account/");
        $("#username").setValue(email);
        $("#password").setValue(password);
        $(".woocommerce-form-login__submit").click();

        $(".woocommerce-MyAccount-content").shouldHave(text(
                "Добро пожаловать, " + email.replace("@test.ru", "")));
        $(".woocommerce-MyAccount-content").$(byText("Выйти")).click();
    }

}
