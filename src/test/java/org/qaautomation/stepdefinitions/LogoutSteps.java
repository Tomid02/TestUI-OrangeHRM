package org.qaautomation.stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.qaautomation.pages.LoginPage;

import static org.qaautomation.stepdefinitions.LoginSteps.dashboardPage;


public class LogoutSteps {
    WebDriver driver;
    LoginPage loginPage;

    @And("The user displays the menu and clicks on the {string} option.")
    public void theUserDisplaysTheMenuAndClicksOnTheOption(String option) {
        dashboardPage.openUserDropdown();
        dashboardPage.selectOption(option);
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        Assert.assertTrue("[WARNING] No fue redirigido a la pagina de Login", loginPage.isOnLoginPage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado despues del escenario");
        }
    }
}
