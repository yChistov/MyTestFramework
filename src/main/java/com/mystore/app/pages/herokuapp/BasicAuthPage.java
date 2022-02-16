package com.mystore.app.pages.herokuapp;

import com.codeborne.selenide.SelenideElement;
import com.mystore.app.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class BasicAuthPage extends BasePage {

  private final SelenideElement basicAuth = $(".example p");

  public BasicAuthPage(String pageUrl) {
    super(pageUrl);
  }

  public String getBasicAuth() {
    return basicAuth.getText();
  }
}
