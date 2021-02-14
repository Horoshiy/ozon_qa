package ru.ozon.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
@Feature("Main Page content")
public class MainPageTests extends TestBase {

    @Test
    @Story("Check for loading and errors")
    @AllureId("1663")
    @DisplayName("Main page is loading")
    void ozonPictureMainPageTest() {
        open("");
        $("header img").shouldHave(Condition.attribute("alt", "Ozon"));
    }
}
