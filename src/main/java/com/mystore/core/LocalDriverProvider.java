package com.mystore.core;

import com.codeborne.selenide.WebDriverProvider;
import com.mystore.helpers.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class LocalDriverProvider implements WebDriverProvider {

    private WebDriver driver;

    @Override
    public WebDriver createDriver(Capabilities desiredCapabilities) {

        switch (TestConfig.browser) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "opera":
                driver =WebDriverManager.operadriver().create();
                break;
        }
        return driver;
    }
}
