package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;
import drivers.DriverFactory;


public class LoginPage {

	WebDriver driver = DriverFactory.getDriver();

    By signInButton = By.id("nav-link-accountList-nav-line-1");
    By email = By.id("ap_email_login");
    By continueBtn = By.id("continue");
    By password = By.id("ap_password");
    By loginBtn = By.id("signInSubmit");

    public void launchApplication() {

        driver.get(ConfigReader.getProperty("url"));
    }

    public void clickSignIn() {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));

        driver.findElement(signInButton).click();
    }

    public void enterEmail(String userEmail) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        driver.findElement(email).sendKeys(userEmail);
    }

    public void clickContinue() {

        driver.findElement(continueBtn).click();
    }

    public void enterPassword(String pwd) {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {

        driver.findElement(loginBtn).click();
    }

    public void verifyLoginSuccess() {

        System.out.println("Login Successful");
    }
}
