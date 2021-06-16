package com.mystore.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.mystore.app.AppConfig;
import com.mystore.core.LocalDriverProvider;
import com.mystore.core.SelenoidDriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Driver {

  public static void initDriver() {
    TestConfig.initConfig();
    Configuration.driverManagerEnabled = false;
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize = "1920x1080";
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
    WebDriverWait wait = new WebDriverWait(currentDriver(), 10);
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

  public static void takeScreenshot() {

    File scrFile = ((TakesScreenshot) currentDriver()).getScreenshotAs(OutputType.FILE);

    String path =
        System.getProperty("user.dir")
            + File.separator
            + "test-output"
            + File.separator
            + "screenshots"
            + File.separator
            + " "
            + "screenshot_"
            + (new SimpleDateFormat("HHmmssSSS").format(new Date()))
            + ".png";
    try {
      FileUtils.copyFile(scrFile, new File(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static List<LogEntry> getBrowserLogs() {
    LogEntries log = currentDriver().manage().logs().get("browser");
    List<LogEntry> logList = log.getAll();
    return logList;
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
}
