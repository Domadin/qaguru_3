package tests;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainTest {
    @Test
    public void archiveDepositsCount() {
        Selenide.open("https://alfabank.ru/make-money/archive/");
        $(by("data-test-id", "tabs-list")).$(byText("Депозиты")).click();
        $$(by("data-widget-name", "CatalogCard")).shouldHave(size(5));
    }

}
