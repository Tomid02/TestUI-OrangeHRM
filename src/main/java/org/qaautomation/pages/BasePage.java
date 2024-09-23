package org.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement element){
        if(isButton(element)){
            element.click();
        }
        else {
            throw new IllegalArgumentException("This element is not a button");
        }
    }

    public boolean isButton(WebElement element){
        String tagName = element.getTagName();
        String typeAttribute = element.getAttribute("type");
        return tagName.equalsIgnoreCase("button") || typeAttribute.equalsIgnoreCase("submit");
    }

}
