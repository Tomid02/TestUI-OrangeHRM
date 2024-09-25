package org.qaautomation.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.qaautomation.stepdefinitions.LoginSteps.employeeListPage;

public class DeleteEmployeeSteps {
    WebDriver driver;

    @When("the user clicks the delete button in the employee list")
    public void theUserClicksDeleteBtn(){
        employeeListPage.clickDeleteEmployeeBtn(10);
    }

    @And("the user clicks the confirm delete button")
    public void theUserClickConfirmDeleteBtn(){
       employeeListPage.clickDeleteConfirmBtn();
    }

    @Then("the user should see an alert with the message {string}")//Successfully Deleted
    public void theUserShouldSeeAnAlert(String expectedMessage){
        Assert.assertEquals("[WARNIG] El mensaje no coincide con el esperado", expectedMessage, employeeListPage.getSuccessMessage(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado despues del escenario");
        }
    }
}
