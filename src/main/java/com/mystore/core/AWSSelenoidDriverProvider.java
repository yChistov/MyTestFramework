package com.mystore.core;

import com.codeborne.selenide.WebDriverProvider;
import com.mystore.helpers.TestConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AWSSelenoidDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> prefs = new HashMap<>();
        switch (TestConfig.browser) {
            case "chrome":
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.setExperimentalOption("prefs", prefs);
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "128.0");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            case "firefox":
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "125.0");
                break;
            case "edge":
                capabilities.setCapability("browserName", "opera");
                capabilities.setCapability("browserVersion", "109.0");
                break;
            default:
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "128.0");
                break;
        }
        capabilities.setCapability(
                "selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true));
        try {
            return new RemoteWebDriver(new URL("http://172.25.16.1:4444/wd/hub"), capabilities);
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to create driver", e);
        }
    }
}
