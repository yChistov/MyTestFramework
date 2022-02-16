package com.mystore.core;

import com.codeborne.selenide.WebDriverProvider;
import com.mystore.helpers.TestConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SelenoidDriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> prefs = new HashMap<>();
        switch (TestConfig.browser) {
            case "chrome":
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "97.0");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            case "firefox":
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "95.0");
                break;
            case "opera":
                capabilities.setCapability("browserName", "opera");
                capabilities.setCapability("browserVersion", "82.0");
                break;
            default:
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "96.0");
                break;
        }
        capabilities.setCapability(
                "selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true));
        try {
            return new RemoteWebDriver(new URL("http://172.24.208.1:4444/wd/hub"), capabilities);
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to create driver", e);
        }
    }
}
