package org.fasttrackit.workshop.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertEquals;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;
    private final static String VALID_EMAIL = "eu@fast.com";
    private final static String VALID_PASSWORD = "eu.pass";
    private final static String INVALID_EMAIL = "invalid@fast.com";
    private final static String INVALID_PASSWORD = "invalid.pass";
    private final static String NO_EMAIL_INSERTED = "Please enter your email!";
    private final static String NO_PASSWORD_INSERTED = "Please enter your password!";
    private final static String INVALID_CREDENTIALS = "Invalid user!";
    private final static String NO_LOGOUT_BUTTON = "The logout button is not displayed";

    @Given("^I access login page$")
    public void I_access_login_page() {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(VALID_EMAIL);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(VALID_PASSWORD);
    }

    @When("^I click login button$")
    public void I_click_login_button() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() {
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        assertEquals(NO_LOGOUT_BUTTON, true, logoutButton.isDisplayed());
    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(INVALID_EMAIL);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(INVALID_PASSWORD);
    }

    @Then("^I expect invalid credentials message$")
    public void I_expect_invalid_credentials_message() {
        WebElement errorMessage = driver.findElement(By.className("error-msg"));
        assertEquals(INVALID_CREDENTIALS, errorMessage.getText());
    }

    @And("^I insert only password$")
    public void I_insert_only_password() {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(VALID_PASSWORD);
    }

    @Then("^I expect no email message$")
    public void I_expect_no_email_message() {
        WebElement errorMessage = driver.findElement(By.className("error-msg"));
        assertEquals(NO_EMAIL_INSERTED, errorMessage.getText());
    }

    @And("^I insert only email$")
    public void I_insert_only_email() {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(VALID_EMAIL);
    }

    @Then("^I expect no password message$")
    public void I_expect_no_password_message() {
        WebElement errorMessage = driver.findElement(By.className("error-msg"));
        assertEquals(NO_PASSWORD_INSERTED, errorMessage.getText());
    }
}
