package com.mystore.tests;

import com.mystore.helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

@Listeners(TestListener.class)
public class GoogleTests extends BaseTest {

    @Step
    @Test(priority = 6)
    @Description(value = "google check")
    public void googleTest() {
        app.googleHomePage.open();
        app.googleHomePage.enterText("google");
    }
}
