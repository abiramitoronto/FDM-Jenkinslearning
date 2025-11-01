package com.fdmgroup.Stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.fdmgroup.DataFile.DataFile;
import com.fdmgroup.Stepdefinitions.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F1_SignInTest_StepDef {
	
	@Given("User launches the application")
	public void user_launches_the_application() {
		Hooks.driver.navigate().to(DataFile.HomeUrl);
	}

	@Then("User is able to view the Scotiabank logo")
	public void user_is_able_to_view_the_scotiabank_logo() {
		 assertTrue(Hooks.signinpage.isLogoDisplayed());
	}

	@Then("User is able to click on the canadapost link")
	public void user_is_able_to_click_on_the_canadapost_link() {
	    Hooks.signinpage.clickcadPostLink();
	}

	@Then("User verify the header {string}")
	public void user_verify_the_header(String string) {
		assertTrue(Hooks.signinpage.isheaderDisplayed()	);
	}

	@Then("User is able to navigate to the home page")
	public void user_is_able_to_navigate_to_the_home_page() throws InterruptedException {
		Hooks.driver.navigate().back();
   	    Thread.sleep(3000);
	}

	@Given("User click on the SignIn button")
	public void user_click_on_the_sign_in_button() {
	   Hooks.signinpage.clicksigniinButton();
	}

	@Then("the user clicks on the Registerpage signin button")
	public void the_user_clicks_on_the_registerpage_signin_button() throws InterruptedException {
		System.out.println("beforeclick");
	   Hooks.signinpage.clickRegsigniinButton();
	   System.out.println("afterclick");
	   Thread.sleep(5000);
	}

	@When("User enter the invalid {string} and {string}")
	public void user_enter_the_invalid_and(String username, String password) throws InterruptedException {
		Hooks.signinpage.enterUsername(username);
	    Thread.sleep(1000);
	    Hooks.signinpage.enterPassword(password);
	    Thread.sleep(1000); 
	}

	@Then("User is able to see the error message")
	public void user_is_able_to_see_the_error_message() throws InterruptedException {
	    assertTrue(Hooks.signinpage.isUsernameErrDisplayed());
	    assertTrue(Hooks.signinpage.isPasswordErrDisplayed());
	    Thread.sleep(3000);
	}
	
	@Then("the user clicks on the remember checkbox")
	public void the_user_clicks_on_the_remember_checkbox() {
		Hooks.signinpage.clickRemembercheckbox();
	}

}
