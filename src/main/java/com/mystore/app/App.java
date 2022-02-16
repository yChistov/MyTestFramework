package com.mystore.app;

import com.mystore.app.pages.elmir.ElmirPage;
import com.mystore.app.pages.google.GoogleHomePage;
import com.mystore.app.pages.herokuapp.*;

public class App {
    public LoginPage loginPage;
    public AddAndRemovePage addAndRemovePage;
    public BasicAuthPage basicAuthPage;
    public DropDownPage dropDownPage;
    public ShadowDomPage shadowDomPage;
    public GoogleHomePage googleHomePage;
    public ElmirPage elmirPage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
        addAndRemovePage = PageBuilder.buildAddAndRemovePage();
        basicAuthPage = PageBuilder.buildBasicAuthPage();
        dropDownPage = PageBuilder.buildDropDownPage();
        shadowDomPage = PageBuilder.buildShadowDomPage();
        googleHomePage = PageBuilder.buildGoogleHomePage();
        elmirPage = PageBuilder.buildElmirPage();
    }
}
