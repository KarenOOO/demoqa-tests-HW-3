package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ProjectConfiguration {
    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.browser = webConfig.getBrowserName();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.pageLoadStrategy = "eager";

        if ("true".equalsIgnoreCase(webConfig.isRemote())) {
            Configuration.remote = String.valueOf(webConfig.getRemoteUrl());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserVersion", Configuration.browserVersion);
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}