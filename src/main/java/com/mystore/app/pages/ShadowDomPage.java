package com.mystore.app.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;

public class ShadowDomPage extends BasePage {

  public ShadowDomPage(String pageUrl) {
    super(pageUrl);
  }

  public SelenideElement getElement() {
    return $(shadowCss("p > slot", "#content > my-paragraph:nth-child(4)"));
  }

  public String getText() {
    return getElement().getText();
  }
}
