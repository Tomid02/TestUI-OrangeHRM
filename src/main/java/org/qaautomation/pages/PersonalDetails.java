package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PersonalDetails extends BasePage{

    @FindBy(css = ".oxd-input.oxd-input--active.orangehrm-firstname")
    WebElement firstNameField;

    @FindBy(css = ".oxd-input.oxd-input--active.orangehrm-middlename")
    WebElement middleNameField;

    @FindBy(css = ".oxd-input.oxd-input--active.orangehrm-lastname")
    WebElement lastNameField;

    @FindBy(className = "oxd-select-text-input")
    WebElement nationalityDropdown;

    @FindBy(css = ".oxd-select-dropdown.--positon-bottom")
    List<WebElement> nationalityList;

    @FindBy(css = ".oxd-radio-input.oxd-radio-input--active.--label-right.oxd-radio-input")
    WebElement genderRadioInput;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement saveBtn;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement successMessage;

    public PersonalDetails(WebDriver driver) {
        super(driver);
    }

    public void entersFirstName(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    public void entersMiddleName(String middleName){
        middleNameField.sendKeys(middleName);
    }

    public void entersLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void selectNationality(String nationality){
        nationalityDropdown.click();
        for(WebElement nation : nationalityList){
            if(nation.getText().equalsIgnoreCase(nationality)){
                nation.click();
            }
        }
    }

    public void clicksSaveBtn(){
        saveBtn.click();
    }

    public void selectGender(){
        genderRadioInput.click();
    }

    public String getSuccessMessage(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(successMessage));
        return successMessage.getText();
    }

}
