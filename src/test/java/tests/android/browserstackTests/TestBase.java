package tests.android.browserstackTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.android.browserstackTests.drivers.BrowserstackDriver;
import tests.android.browserstackTests.drivers.MobileDriver;
import tests.android.browserstackTests.helpers.Attach;

import static com.codeborne.selenide.Selenide.*;

class TestBase {

    @BeforeAll
    static void beforeAll() {
        switch (System.getProperty("env")) {
            case "android":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "mobile":
                Configuration.browser = MobileDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();

        Attach.pageSource();

        closeWebDriver();

        if (!System.getProperty("env").equals("mobile")) Attach.addVideo(sessionId);
    }
}
