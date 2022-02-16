package com.mystore.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.mystore.app.AppConfig;
import com.mystore.core.AWSSelenoidDriverProvider;
import com.mystore.core.LocalDriverProvider;
import com.mystore.core.SelenoidDriverProvider;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class Driver {

    public static void initDriver() {
        TestConfig.initConfig();
        Configuration.driverManagerEnabled = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;
        Configuration.headless = TestConfig.isHeadless();
        switch (TestConfig.environment) {
            case "local":
                Configuration.browser = LocalDriverProvider.class.getName();
                break;
            case "docker":
                Configuration.browser = SelenoidDriverProvider.class.getName();
                break;
            case "aws":
                Configuration.browser = AWSSelenoidDriverProvider.class.getName();
                break;
        }
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }

    public static void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor) currentDriver();
        try {
            js.executeScript(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(urlChunk));
    }

    public static void waitForUrlDoesNotContain(String urlChunk) {
        int maxTime = 20;
        while (currentDriver().getCurrentUrl().contains(urlChunk) && maxTime > 0) {
            wait(1);
            maxTime--;
        }
    }

    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void clearAllCookies() {
        open(AppConfig.baseUrl);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public static void close() {
        currentDriver().quit();
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<LogEntry> getBrowserLogs() {
        LogEntries log = currentDriver().manage().logs().get("browser");
        return log.getAll();
    }

    // COOKIES

    public static void addCookie(Cookie cookie) {
        currentDriver().manage().addCookie(cookie);
    }

    public static Cookie getCookie(String cookieName) {
        return currentDriver().manage().getCookieNamed(cookieName);
    }

    public static void deleteCookie(String cookieName) {
        currentDriver().manage().deleteCookieNamed(cookieName);
    }

    @Attachment(type = "image/png")
    public static byte[] screenshot() {
        return ((TakesScreenshot) currentDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static SelenideElement expandRootElement(SelenideElement element) {
        WebElement rootElement = Selenide.executeJavaScript("return arguments[0].shadowRoot", element);
        return $(rootElement);
    }

    public static WebElement expandElement(WebElement element) {
        return (WebElement)
                ((JavascriptExecutor) currentDriver())
                        .executeScript("return arguments[0].shadowRoot", element);
    }
}
