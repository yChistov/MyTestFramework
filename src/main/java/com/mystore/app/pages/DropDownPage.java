package com.mystore.app.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DropDownPage extends BasePage {

  private SelenideElement dropDown = $(By.id("dropdown"));

  public DropDownPage(String pageUrl) {
    super(pageUrl);
  }

  public void selectOptionByValue(String value) {
    dropDown.selectOption(value);
  }

  public Boolean isSelected() {
    return dropDown.isSelected();
  }
}
