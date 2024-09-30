package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage extends BasePage{

    @FindBy(css = "[name='firstName']")
    WebElement firstNameField;

    @FindBy(css = "[name='middleName']")
    WebElement middleNameField;

    @FindBy(css = "[name='lastName']")
    WebElement lastNameField;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement saveBtn;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement successMessage;

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public void entersFirstname(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    public void entersMiddleName(String middleName){
        middleNameField.sendKeys(middleName);
    }

    public void entersLastName(String lastName){
        lastNameField.sendKeys(lastName);
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
