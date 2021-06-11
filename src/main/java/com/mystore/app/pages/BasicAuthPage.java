package com.mystore.app.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasicAuthPage extends BasePage {

  private SelenideElement basicAuth = $(".example p");

  public BasicAuthPage(String pageUrl) {
    super(pageUrl);
  }

  public String getBasicAuth() {
    return basicAuth.getText();
  }
}
