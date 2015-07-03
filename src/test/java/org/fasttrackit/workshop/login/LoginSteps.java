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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I access login page$")
    public void I_access_login_page() {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @And("^I insert \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_insert_credentials(String emailValue, String passwordValue) {
        insertEmail(emailValue);
        insertPassword(passwordValue);
    }

    @When("^I click login button$")
    public void I_click_login_button() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() {
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        assertThat(logoutButton.isDisplayed(), is(true));
    }

    @Then("^I expect \"([^\"]*)\" error message$")
    public void I_expect_message(String expectedMessage) throws Throwable {
        errorMessageShouldBePresent(expectedMessage);
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String expectedEmail, String expectedPassword) {
        insertEmail(expectedEmail);
        insertPassword(expectedPassword);
    }

    private void errorMessageShouldBePresent(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.className("error-msg"));
        assertThat(expectedMessage, is(errorMessage.getText()));
    }

    private void insertEmail(String expectedEmail) {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(expectedEmail);
    }

    private void insertPassword(String expectedPassword) {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(expectedPassword);
    }

}
