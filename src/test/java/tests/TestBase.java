package tests;

import com.codeborne.selenide.Configuration;
import helpers.WebAttach;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.impl.Cleanup.of;
import static java.util.Map.of;

public class TestBase {

    @BeforeAll
    static void setUp() {

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.of(
//                "enableVNC", true,
//            "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;

    }

    @Attachment
    void addAttachments() {
        WebAttach.screenshotAs("Last screenshot");
        WebAttach.pageSource();
        WebAttach.browserConsoleLogs();
    }
}
