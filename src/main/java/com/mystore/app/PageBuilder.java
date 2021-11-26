package com.mystore.app;

import com.mystore.app.pages.*;

public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("/login");
    }

    public static AddAndRemovePage buildAddAndRemovePage() {
        return new AddAndRemovePage("/add_remove_elements/");
    }

    public static BasicAuthPage buildBasicAuthPage() {
        return new BasicAuthPage("/basic_auth");
    }

    public static DropDownPage buildDropDownPage() {
        return new DropDownPage("/dropdown");
    }

    public static ShadowDomPage buildShadowDomPage() {
        return new ShadowDomPage("/shadowdom");
    }
}
