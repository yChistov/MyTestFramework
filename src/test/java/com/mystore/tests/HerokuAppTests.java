package com.mystore.tests;

import com.mystore.helpers.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

@Listeners(TestListener.class)
public class HerokuAppTests extends BaseTest {
    private static final String WELCOME_TEXT = "Welcome to the Secure Area. When you are done click logout below.";
    private static final String BASIC_AUTH = "Congratulations! You must have the proper credentials.";
    private static final String VALUE_OPTION = "Option 1";
    private static final int NUMBER_OF_BUTTON_CLICKS = 5;
    private static final String SOME_TEXT = "My default text";

    @Step
    @Test(priority = 1)
    @Description(value = "Login with correct credentials")
    public void loginTest() {
        app.loginPage.open();
        app.loginPage.login("tomsmith", "SuperSecretPassword!");
        assertThat("Welcome text is: " + app.loginPage.getWelcomeText(),
                app.loginPage.getWelcomeText().equals(WELCOME_TEXT));
    }

    @Step
    @Test(priority = 2)
    @Description(value = "Added and deleted new button")
    public void deleteButtonTest() {
        app.addAndRemovePage.open();
        app.addAndRemovePage.clickOnAddButton(NUMBER_OF_BUTTON_CLICKS);
        app.addAndRemovePage.clickOnDeleteButton();
        assertThat(app.addAndRemovePage.getDeleteElementsSize(), Matchers.is(0));
    }

    @Step
    @Test(priority = 3)
    @Description(value = "Login with correct credentials into url")
    public void basicAuthTest() {
        app.basicAuthPage.open("admin", "admin");
        assertThat("Title is: " + app.basicAuthPage.getBasicAuth(),
                app.basicAuthPage.getBasicAuth().equals(BASIC_AUTH));
    }

    @Step
    @Test(priority = 4)
    @Description(value = "Chose option into dropdown")
    public void dropDownTest() {
        app.dropDownPage.open();
        app.dropDownPage.selectOptionByValue(VALUE_OPTION);
        assertThat("Option is: " + app.dropDownPage.getText(),
                app.dropDownPage.getText().equals(VALUE_OPTION));
    }

    @Step
    @Test(priority = 5)
    @Description(value = "Shadow DOM check")
    public void shadowDoomTest() {
        app.shadowDomPage.open();
        assertThat("Page text is: " + app.shadowDomPage.getText(),
                app.shadowDomPage.getText().equals(SOME_TEXT));
    }
}
