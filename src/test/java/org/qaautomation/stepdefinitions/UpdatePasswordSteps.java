package org.qaautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.qaautomation.pages.UpdatePasswordPage;

import static org.qaautomation.stepdefinitions.LoginSteps.dashboardPage;

public class UpdatePasswordSteps {

    UpdatePasswordPage updatePasswordPage;

    @When("the user displays the menu and clicks on the Update Password option")
    public void userClicksUpdatePwd(){
        dashboardPage.openUserDropdown();
        updatePasswordPage = dashboardPage.openUpdatePwdPage();
    }

    @And("the user enters the current password: {string}, new password: {string} and confirm password: {string}")
    public void userEnterCurrentNewConfirmPwd(String currentPwd, String newPwd, String confirmPwd){
        updatePasswordPage.entersCurrentPwd(currentPwd);
        updatePasswordPage.entersNewPwd(newPwd);
        updatePasswordPage.entersConfirmPwd(confirmPwd);
    }

    @And("the user clicks save button for the update password")
    public void userClicksSaveBtn(){
        updatePasswordPage.clicksSaveBtn();
    }

    @Then("the user should see an alert with the message {string} indicating that the password was saved successfully")
    public void userShouldSeeAnAlert(String expectedMessage){
        Assert.assertEquals("[WARNING] el mensaje esperado no coincide con el actual", expectedMessage, updatePasswordPage.getSuccessMessage(10));
    }

}
