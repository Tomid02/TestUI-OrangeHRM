package org.qaautomation.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;

    @Before("@LogoutOk")
    public void loginBeforelogout() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.theUserIsOnTheLoginPageOfOrangeHRM();
        loginSteps.theUserEntersValidsCredentials("Admin", "admin123");
        loginSteps.theUserClickTheLoginBtn();
        loginSteps.userLoggedIn();
    }

    @Before("@DeleteEmployeeOk")
    public void loginBeforeDeleteEmployye() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.theUserIsOnTheLoginPageOfOrangeHRM();
        loginSteps.theUserEntersValidsCredentials("Admin", "admin123");
        loginSteps.theUserClickTheLoginBtn();
        loginSteps.userLoggedIn();
        loginSteps.theUserEntersPimModule();
    }

    @After("@testRegresion")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado despues del escenario");
        }
    }

}
