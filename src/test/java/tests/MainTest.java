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

    @Test
    public void baseTest() {
        Selenide.open("https://alfabank.ru/make-money/");
        $(by("data-test-id", "tabs-list"))
                .scrollIntoView(true)
                .$(byText("Страхование вкладов")).click();

        $$("[data-test-id^=\"accordion-item\"]").shouldHaveSize(4);
    }

    @Test
    public void siblingAndParentTest() {
        Selenide.open("https://alfabank.ru/make-money/");
        $(by("data-test-id", "tabs-list"))
                .scrollIntoView(true)
                .$(byText("Описание"))
                .parent()
                .sibling(0).click();

        $$("[data-test-id^=\"accordion-item\"]").shouldHaveSize(4);
    }

    @Test
    public void closestAndPrecedingTest() {
        Selenide.open("https://alfabank.ru/make-money/");
        $(by("data-test-id", "tabs-list"))
                .scrollIntoView(true)
                .$(byText("Что такое вклад?"))
                .closest("button")
                .preceding(0).click();

        $$("[data-test-id^=\"accordion-item\"]").shouldHaveSize(4);
    }
}
