package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdatePasswordPage extends BasePage{

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement currentPasswordField;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement newPasswordField;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement confirmPasswordField;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement saveBtn;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement successMessage;

    @FindBy(css = ".oxd-text.oxd-text--h6.orangehrm-main-title")
    WebElement titlePage;

    public UpdatePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void entersCurrentPwd(String currentPassword){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(titlePage));
        currentPasswordField.sendKeys(currentPassword);
    }

    public void entersNewPwd(String newPassword){
        newPasswordField.sendKeys(newPassword);
    }

    public void entersConfirmPwd(String confirmPassword){
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clicksSaveBtn(){
        saveBtn.click();
    }

    public String getSuccessMessage(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(successMessage));
        return successMessage.getText();
    }

}
