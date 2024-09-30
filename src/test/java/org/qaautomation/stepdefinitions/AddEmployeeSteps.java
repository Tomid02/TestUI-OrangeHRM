package org.qaautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.qaautomation.pages.AddEmployeePage;

import static org.qaautomation.stepdefinitions.OpenPIMModuleSteps.pimModulePage;

public class AddEmployeeSteps {

    AddEmployeePage addEmployeePage;

    @When("the user clicks Add Employee button")
    public void userClicksAddEmployeeBtn(){
        addEmployeePage = pimModulePage.clicksAddEmployeeBtn();
    }

    @And("the user enters the first name: {string}, middle name: {string} and last name: {string}, of the new employee")
    public void userEntersAFullNameEmployee(String firstName, String middleName, String lastName){
        addEmployeePage.entersFirstname(firstName);
        addEmployeePage.entersMiddleName(middleName);
        addEmployeePage.entersLastName(lastName);
    }

    @And("The user clicks on the save new employee button")
    public void userClicksSaveBtn(){
        addEmployeePage.clicksSaveBtn();
    }

    @Then("the user should see an alert with the message {string} indicating that it was saved successfully")
    public void userShouldSeeAnAlert(String expectedMessage){
        Assert.assertEquals("[WARNIGN] el mensaje esperado no coincide con el actual", expectedMessage, addEmployeePage.getSuccessMessage(10));
    }
}
