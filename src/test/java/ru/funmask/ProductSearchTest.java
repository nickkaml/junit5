package ru.funmask;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductSearchTest {

    @ParameterizedTest(name = "Проверка наличия товара {0} в результатах поиска")
    @ValueSource(strings = { "Маска Барака Обамы", "Маска Дональда Трампа", "Маска Джо Байдена" })
    void searchTest(String product) {
        open("https://fun-mask.ru/");
        $(".aws-search-field").setValue(product);
        $(".aws-search-result").shouldHave(text(product));
    }
}
