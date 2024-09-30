package org.qaautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.qaautomation.stepdefinitions.OpenPIMModuleSteps.pimModulePage;

public class DeleteEmployeeSteps {

    @When("the user clicks the delete button in the employee list")
    public void theUserClicksDeleteBtn(){
        pimModulePage.clickDeleteEmployeeBtn(10);
    }

    @And("the user clicks the confirm delete button")
    public void theUserClickConfirmDeleteBtn(){
       pimModulePage.clickDeleteConfirmBtn();
    }

    @Then("the user should see an alert with the message {string} indicating that the deletion was successful")//Successfully Deleted
    public void theUserShouldSeeAnAlert(String expectedMessage){
        Assert.assertEquals("[WARNIG] El mensaje esperado no coincide con el actual", expectedMessage, pimModulePage.getSuccessMessage(10));
    }
}
