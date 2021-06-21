package com.mystore.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.mystore.app.App;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import static com.mystore.helpers.Driver.*;

public class BaseTest {

  protected App app;
  protected SoftAssert softAssert;
  protected Logger logger;

  @BeforeClass
  public void setUp() {
    initDriver();
    app = new App();
    softAssert = new SoftAssert();
    logger = LogManager.getLogger("");
    DOMConfigurator.configure("src/main/resources/log4j.xml");
    PropertyConfigurator.configure("src/main/resources/log4j.properties");
    SelenideLogger.addListener(
        "AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }

  @AfterMethod
  public void clearCookies() {
    clearAllCookies();
  }

  @AfterClass
  public void tearDown() {
    close();
  }
}
