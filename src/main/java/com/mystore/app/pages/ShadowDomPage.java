package com.mystore.app.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.mystore.helpers.Driver.currentDriver;
import static com.mystore.helpers.Driver.expandElement;

public class ShadowDomPage extends BasePage {

  public ShadowDomPage(String pageUrl) {
    super(pageUrl);
  }

  public SelenideElement getElementText() {
    return $(shadowCss("ul > li:first-child", "my-paragraph")).shouldHave(text("Let's have some different text!"));
  }

  public String getElement() {
    WebElement root1 = currentDriver().findElement(By.tagName("my-paragraph"));
    WebElement shadowRoot1 = expandElement(root1);
    return shadowRoot1.findElement(By.cssSelector("ul > li:nth-child(1)")).getText();
  }

  public String getText() {
    return getElementText().getText();
  }
}
