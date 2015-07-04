package org.fasttrackit.workshop.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.menu.MainMenuView;
import org.fasttrackit.workshop.preferences.PreferencesWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PreferencesSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreferencesSteps.class);
    public static final String VALID_EMAIL = "eu@fast.com";
    public static String NEW_PASSWORD = "eu.p";
    public static String VALID_PASSWORD = "eu.pass";

    private PreferencesWindow preferencesWindow = new PreferencesWindow();

    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() {
        preferencesWindow.open();
    }

    @And("^I input current password$")
    public void I_input_current_password() {
        preferencesWindow.typeCurrentPassword(VALID_PASSWORD);
    }

    @And("^I input new password$")
    public void I_input_new_password() {
        preferencesWindow.typeNewPassword(NEW_PASSWORD);
    }

    @And("^I confirm the new password$")
    public void I_confirm_the_new_password() {
        preferencesWindow.typeConfirmPassword(NEW_PASSWORD);
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button() {
        preferencesWindow.save();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void I_should_see_message(String message) {
        preferencesWindow.isMessageDisplayed(message);
        PreferencesSteps.VALID_PASSWORD = NEW_PASSWORD;
    }

    @And("^I close Preference window$")
    public void I_close_Preference_window() {
        preferencesWindow.close();
    }

    @And("^I logout$")
    public void I_logout() {
        MainMenuView.logoutLink.assertClick();
    }
}
