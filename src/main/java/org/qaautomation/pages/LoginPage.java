package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement loginBtn;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    WebElement invalidCredentialsMsg;

    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    WebElement requiredMsg;

    @FindBy(css = ".oxd-text.oxd-text--h5.orangehrm-login-title")
    WebElement loginTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        clickButton(loginBtn);
        return new DashboardPage(driver);
    }

    public String getInvalidCredentialsText(){
        return invalidCredentialsMsg.getText();
    }

    public String getRequiredText(){
        return requiredMsg.getText();
    }

    public boolean isOnLoginPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginTitle));
        return loginTitle.isDisplayed();
    }


}
