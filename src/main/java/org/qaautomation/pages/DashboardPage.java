package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(className = "oxd-userdropdown-img")
    WebElement userImg;

    @FindBy(className = "oxd-userdropdown-link")
    List<WebElement> optionsDropdown;

    @FindBy(css = ".oxd-text.oxd-text--span.oxd-main-menu-item--name")
    List<WebElement> itemsMenu;


    public DashboardPage (WebDriver driver){
        super(driver);
    }

    public void openUserDropdown(){
        userImg.click();
    }

    public boolean isLoginSuccessful(int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(userImg));
        return userImg.isDisplayed();
    }

    public void selectOption(String optionName) {
        for (WebElement option : optionsDropdown) {
            if (option.getText().equals(optionName)){
                option.click();
                break;
            }
        }
    }

    public PIMModulePage selectItemMenu(String itemName) {
        for (WebElement item : itemsMenu) {
            if (item.getText().equals(itemName)){
                item.click();
                return new PIMModulePage(driver);
            }
        }
        return null;
    }

    public UpdatePasswordPage openUpdatePwdPage(){
        selectOption("Change Password");
        return new UpdatePasswordPage(driver);
    }
}
