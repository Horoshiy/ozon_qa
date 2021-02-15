package ru.ozon.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static ru.ozon.helpers.DriverHelper.getConsoleLogs;

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

    @Test
    @Story("Check for loading and errors")
    @AllureId("1653")
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrorsTest() {
        open("");
        assertThat(getConsoleLogs(), not(containsString("SEVERE")));
    }

    @Test
    void topBarCheckTest() {
        open("");
        $(by("data-widget", "topBar")).find("button").should(exist);
        $(by("data-widget", "topBar")).shouldHave(text("Мобильное приложение"));
    }
}
