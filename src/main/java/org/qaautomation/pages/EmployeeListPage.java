package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeeListPage extends BasePage{

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary")
    WebElement addBtn;

    @FindBy(css = ".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable")
    WebElement employeeBtn;

//    @FindBy(css = ".oxd-icon.bi-trash")
//    WebElement deleteEmployeeBtn;

    @FindBy(xpath = "//button/i[@class='oxd-icon bi-trash']")
    WebElement deleteEmployeeBtn;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin")
    WebElement deleteConfirmBtn;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement successMessage;

    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteEmployeeBtn(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(deleteEmployeeBtn));
        deleteEmployeeBtn.click();
    }

    public void clickDeleteConfirmBtn(){
        deleteConfirmBtn.click();
    }

    public String getSuccessMessage(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(successMessage));
        return successMessage.getText();
    }

}
