package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
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

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I open login page$")
    public void I_open_login_page() {
        driver.get("file:///D:/Testy/src/test/functional/login.html");

        //loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) {
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
    }

    @Given("^I access login page$")
    public void I_access_login_page() throws Throwable {
        System.out.println("Aici ar trebui sa deschid login page.");
    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
        System.out.println("User + pass.");
    }

    @When("^I click login button$")
    public void I_click_login_button() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I expect invalid credentials message$")
    public void I_expect_invalid_credentials_message() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^I open this url \"([^\"]*)\"$")
    public void I_open_this_url(String url) {
        driver.get(url);
    }

    @Then("^I send (\\d+) into search field$")
    public void I_sent_into_search(int arg1) {
        System.out.println("numarul este: " + arg1);
    }
}
