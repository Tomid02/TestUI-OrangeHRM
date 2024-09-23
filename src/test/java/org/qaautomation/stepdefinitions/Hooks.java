package org.qaautomation.stepdefinitions;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;

    @Before("@LogoutOk")
    public void loginBeforelogout() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.theUserIsOnTheLoginPageOfOrangeHRM();
        loginSteps.theUserEntersValidsCredentials("Admin", "admin123");
        loginSteps.theUserClickTheLoginBtn();
        loginSteps.userLoggedIn();
    }


}
