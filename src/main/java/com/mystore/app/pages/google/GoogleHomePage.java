package com.mystore.app.pages.google;

import com.codeborne.selenide.SelenideElement;
import com.mystore.app.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage extends BasePage {

  private final SelenideElement inputField = $(By.name("q"));

  public GoogleHomePage(String pageUrl) {
    super(pageUrl);
  }

  public void enterText(String value) {
    inputField.sendKeys(value, Keys.ENTER);
  }

}
