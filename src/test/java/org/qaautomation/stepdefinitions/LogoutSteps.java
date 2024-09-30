package org.qaautomation.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.qaautomation.pages.LoginPage;
import static org.qaautomation.stepdefinitions.LoginSteps.dashboardPage;
import static org.qaautomation.stepdefinitions.LoginSteps.driver;


public class LogoutSteps {
    LoginPage loginPage = new LoginPage(driver);

    @When("the user displays the menu and clicks on the {string} option")
    public void theUserDisplaysTheMenuAndClicksOnTheOption(String option) {
        dashboardPage.openUserDropdown();
        dashboardPage.selectOption(option);
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        Assert.assertTrue("[WARNING] No fue redirigido a la pagina de Login", loginPage.isOnLoginPage());
    }
}
