package com.mystore.tests;

import com.mystore.helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

@Listeners(TestListener.class)
public class ElmirTests extends BaseTest {

    @Step
    @Test(priority = 6)
    @Description(value = "service center check")
    public void googleTest() {
        app.elmirPage.open();
        app.elmirPage.closePopup();
        app.elmirPage.clickOnServiceButton();
        sleep(5000);
    }
}
