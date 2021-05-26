package com.mystore.tests;

import org.testng.annotations.Test;

public class MyTest extends BaseTest {

  @Test
  void ableToRunDefaultDriverOnSelenoid() {
    app.loginPage.open();
    app.loginPage.login("tomsmith", "SuperSecretPassword!");

    logger.info("Sample info message");
    logger.warn("Sample warn message");
    logger.error("Sample error message");
    logger.fatal("Sample fatal message");

    softAssert.assertEquals(2, 2);
    softAssert.assertAll();
  }
}
