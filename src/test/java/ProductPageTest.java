import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPageTest {


    @ParameterizedTest(name = "Артикул {1} соответсвует цвету {0}")
    @MethodSource("namedArguments")
    void colorProduct(String color, String SKU) {
        open("https://www.wildberries.ru/catalog/61914204/detail.aspx?targetUrl=GP");
        $("a[aria-label='" + color + "']").click();
        $("#productNmId").shouldHave(text(SKU));

    }

    static Stream<Arguments> namedArguments() {
        return Stream.of(
                Arguments.of("серый", "81261124"),
                Arguments.of("бирюзовый", "61914204"),
                Arguments.of("черный", "61914203")
        );
    }


}
