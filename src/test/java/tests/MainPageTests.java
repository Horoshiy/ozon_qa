package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
@Feature("Main Page content")
public class MainPageTests {

    private void openMainPage() {
        open("http://ozon.ru");
    }

    @Test
    @Story("Check for loading and errors")
    @DisplayName("Main page is loading")
    void ozonPictureMainPageTest() {
        openMainPage();
        $("header img").shouldHave(Condition.attribute("alt", "Ozon"));
    }
}
