package org.qaautomation.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static org.qaautomation.stepdefinitions.LoginSteps.driver;

public class Hooks {
    @Before("@LogoutOk")
    public void loginBeforelogout() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.theUserIsOnTheLoginPageOfOrangeHRM();
        loginSteps.theUserEntersValidsCredentials("Admin", "admin123");
        loginSteps.theUserClickTheLoginBtn();
        loginSteps.userLoggedIn();
    }

    @Before("@beforeOpenPIM")
    public void loginBeforeDeleteEmployye() {
        LoginSteps loginSteps = new LoginSteps();
        OpenPIMModuleSteps openPIMModuleSteps = new OpenPIMModuleSteps();
        loginSteps.theUserIsOnTheLoginPageOfOrangeHRM();
        loginSteps.theUserEntersValidsCredentials("Admin", "admin123");
        loginSteps.theUserClickTheLoginBtn();
        loginSteps.userLoggedIn();
        openPIMModuleSteps.theUserEntersPimModule();
        openPIMModuleSteps.userShouldRedirectedPIMPage();
    }

    @After()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado despues del escenario - Hooks");
        }
    }
}
