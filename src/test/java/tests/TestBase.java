package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfiguration;
import config.WebConfig;
import helpers.WebAttach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import pages.RegistrationPage;


public class TestBase {
    public RegistrationPage registrationPage;
    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @DisplayName("Открываем страницу https://demoqa.com")
    @BeforeAll
    static void beforeAll() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
    }

    @BeforeEach
    void setUpEachTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        //registrationPage = RegistrationPage.openPage();
    }

    @AfterEach
    void addAttachments() {
        WebAttach.screenshotAs("Last screenshot");
        WebAttach.pageSource();
        WebAttach.browserConsoleLogs();
        WebAttach.addVideo();
        Selenide.closeWebDriver();
    }
}