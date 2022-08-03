package page_objects;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class TestsBase {

    @BeforeEach
    public void openBrowser() {
        Configuration.baseUrl = ("https://demoqa.com");
        Configuration.browserSize = "1280x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }
}
