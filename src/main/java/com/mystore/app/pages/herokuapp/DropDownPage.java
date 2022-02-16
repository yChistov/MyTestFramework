package com.mystore.app.pages.herokuapp;

import com.codeborne.selenide.SelenideElement;
import com.mystore.app.pages.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DropDownPage extends BasePage {

  private final SelenideElement dropDown = $(By.id("dropdown"));

  public DropDownPage(String pageUrl) {
    super(pageUrl);
  }

  public void selectOptionByValue(String value) {
    dropDown.selectOption(value);
  }

  public String getText() {
    return dropDown.getText();
  }
}
