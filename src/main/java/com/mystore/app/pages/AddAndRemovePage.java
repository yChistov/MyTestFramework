package com.mystore.app.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddAndRemovePage extends BasePage {

  private SelenideElement addElementBtn = $(".example button");
  private ElementsCollection deleteBtnList = $$("#elements .added-manually");

  public AddAndRemovePage(String pageUrl) {
    super(pageUrl);
  }

  public void clickOnAddButton(int number) {
    IntStream.range(0, number)
        .forEach(
            i -> {
              addElementBtn.click();
            });
  }

  public void clickOnDeleteButton() {
    deleteBtnList.forEach(SelenideElement::click);
  }

  public int getDeleteElementsSize() {
    return deleteBtnList.size();
  }
}
