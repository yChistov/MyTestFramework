package com.mystore.core;

import com.codeborne.selenide.WebDriverProvider;
import com.mystore.helpers.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriverProvider implements WebDriverProvider {

    private WebDriver driver;

    @Override
    public WebDriver createDriver(Capabilities desiredCapabilities) {

        switch (TestConfig.browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
