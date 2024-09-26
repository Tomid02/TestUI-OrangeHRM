package org.qaautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.qaautomation.pages.PersonalDetails;

import static org.qaautomation.stepdefinitions.OpenPIMModuleSteps.employeeListPage;

public class EditEmployePersonalDetailsSteps {
    PersonalDetails personalDetails;

    @When("the user clicks on an employee's card")
    public void userClicksEmployeeCard(){
        personalDetails = employeeListPage.clicksEmployeeBtn();
    }

    @And("the user enters the first name: {string}, middle name: {string} and last name: {string}")
    public void userEntersFirstMiddleLastName(String firstname,String middleName,String lastName){
        personalDetails.entersFirstName(firstname);
        personalDetails.entersMiddleName(middleName);
        personalDetails.entersLastName(lastName);
    }

    @And("the user selects the nationality {string} of the employee")
    public void userSelectsNationality(String nationality){
        personalDetails.selectNationality(nationality);
    }

    @And("the user selects the gender of the employee")
    public void userSelectsGender(){
        personalDetails.selectGender();
    }

    @And("the user clicks Save button")
    public void userClicksSaveBtn(){
        personalDetails.clicksSaveBtn();
    }

    @Then("the user should see an alert with the message {string} indicating that the update was successful")
    public void theUserShouldSeeAnAlert(String expectedMessage){
        Assert.assertEquals("[WARNIG] El mensaje no coincide con el esperado", expectedMessage, personalDetails.getSuccessMessage(10));
    }

}
