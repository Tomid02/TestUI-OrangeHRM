package org.qaautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qaautomation.pages.DashboardPage;
import org.qaautomation.pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    public static WebDriver driver ;
    LoginPage loginPage;
    public static DashboardPage dashboardPage;

    public LoginSteps() {
    }

    @Given("the user is on the login page of OrangeHRM")
    public void theUserIsOnTheLoginPageOfOrangeHRM(){
        ChromeOptions options = new ChromeOptions();
        String pathChromeDriver = System.getProperty("user.dir") + "\\rsc\\drivers\\chromedriver.exe";

        System.out.println("[Info]Ruta driver " + pathChromeDriver);

        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid credentials: username {string} and password {string}")
    public void theUserEntersValidsCredentials(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void theUserClickTheLoginBtn(){
        dashboardPage = this.loginPage.clickLoginButton();
    }

    @Then("the user should be logged in")
    public void userLoggedIn(){
        Assert.assertTrue("[WARNING] Error al iniciar sessión", dashboardPage.isLoginSuccessful(40));
    }

    @When("the user enter invalids credentials: username {string} and password {string}")
    public void theUserEntersInvalidCredentials(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("the user should see the error message {string} indicating that the credentials are invalid")
    public void userShouldSeeErrorMsgCredentialsInvalid(String expectedMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")));
        Assert.assertEquals("[WARNING] EL mensaje esperado no coincide con el actual", expectedMessage, loginPage.getInvalidCredentialsText());
    }

    @Then("the user should see the error message {string} indicating that a field is required")
    public void userShouldSeeErrorMsgFieldRequired(String expectedMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")));
        Assert.assertEquals("[WARNING] EL mensaje esperado no coincide con el actual", expectedMessage, loginPage.getRequiredText());
    }
}
