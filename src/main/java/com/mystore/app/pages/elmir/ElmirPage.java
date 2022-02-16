package com.mystore.app.pages.elmir;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mystore.app.pages.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class ElmirPage extends BasePage {

    private final SelenideElement closePopup = $(By.cssSelector("#subscribe-close"));

    private final SelenideElement contactButton = $(By.cssSelector(".menulist .p2.submenu > a"));

    private final SelenideElement serviceButton = $(By.cssSelector(".p2.submenu li:nth-child(3) > a"));

    public ElmirPage(String pageUrl) {
        super(pageUrl);
    }

    public void closePopup() {
        closePopup.click();
    }

    public void clickOnServiceButton() {
        contactButton.shouldBe(Condition.visible);
        actions().moveToElement(contactButton).moveToElement(serviceButton).click(serviceButton).build().perform();
    }
}
