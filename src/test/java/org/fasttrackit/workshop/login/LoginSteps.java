package org.fasttrackit.workshop.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    public LoginSteps() {
        initPage();
    }

    public void initPage() {
        loginPage = PageFactory.
                initElements(driver, LoginPage.class);
    }

    @Given("^I access login page$")
    public void I_access_login_page() {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @And("^I insert \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_insert_credentials(String emailValue, String passwordValue) {
        loginPage.enterEmail(emailValue);
        loginPage.enterPassword(passwordValue);
    }

    @When("^I click login button$")
    public void I_click_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() {
        loginPage.checkLogoutButton();
    }

    @Then("^I expect \"([^\"]*)\" error message$")
    public void I_expect_message(String expectedMessage) {
        loginPage.errorMessageShouldBePresent(expectedMessage);
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String expectedEmail, String expectedPassword) {
        loginPage.enterEmail(expectedEmail);
        loginPage.enterPassword(expectedPassword);
    }

}
