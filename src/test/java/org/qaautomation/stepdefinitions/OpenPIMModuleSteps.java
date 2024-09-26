package org.qaautomation.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.qaautomation.pages.EmployeeListPage;

import static org.qaautomation.stepdefinitions.LoginSteps.dashboardPage;

public class OpenPIMModuleSteps {

    public static EmployeeListPage employeeListPage;

    @When("the user enters the PIM module")
    public void theUserEntersPimModule(){
        employeeListPage = dashboardPage.selectItemMenu("PIM");
    }

    @Then("the user should bee redirected to the PIM page")
    public void userShouldRedirectedPIMPage(){
        Assert.assertTrue("[WARNIGN] el usuario no fue redirigido a la pagina PIM", employeeListPage.isOnPIMModule());
    }
}
