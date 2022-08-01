package page_objects;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestsBase {

    @BeforeEach
    public void openBrowser() {
        Configuration.baseUrl = ("https://demoqa.com");
        Configuration.browserSize = "1280x1080";
    }
}
