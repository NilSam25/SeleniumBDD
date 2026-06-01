package stepdefinitions;

import config.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginSteps {
	
	private static final Logger logger =
            LogManager.getLogger(LoginSteps.class);
	
	LoginPage loginPage = new LoginPage();

    @Given("User launches Amazon application")
    public void user_launches_amazon_application() {
    	logger.info("Launching Amazon application");
        loginPage.launchApplication();
    }

    @When("User clicks on sign in")
    public void user_clicks_on_sign_in() {
    	logger.info("Clicking Sign In button");
        loginPage.clickSignIn();
    }

    @And("User enters valid email")
    public void user_enters_valid_email() {
    	logger.info("Entering email address");
    	loginPage.enterEmail(
                ConfigReader.getProperty("username"));
    }

    @And("User clicks continue button")
    public void user_clicks_continue_button() {
    	logger.info("Clicking Continue button");
        loginPage.clickContinue();
    }

    @And("User enters valid password")
    public void user_enters_valid_password() {
    	logger.info("Entering password");
        loginPage.enterPassword(ConfigReader.getProperty("password"));
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {
    	logger.info("Clicking Login button");
        loginPage.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
    	logger.info("Verifying successful login");
        loginPage.verifyLoginSuccess();
        logger.info("Login verification completed");
    }
}
