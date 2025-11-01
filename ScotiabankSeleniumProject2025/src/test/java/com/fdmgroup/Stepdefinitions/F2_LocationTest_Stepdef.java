package com.fdmgroup.Stepdefinitions;

import com.fdmgroup.DataFile.DataFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F2_LocationTest_Stepdef {


	@Then("User is able to click on the icon")
	public void user_is_able_to_click_on_the_icon() {
	    Hooks.locationPage.clicklocationIcon();
	}
	
	@Then("User verify the header in location page {string}")
	public void user_verify_the_header_in_locationpage(String string) {
		assertTrue(Hooks.locationPage.islocationheaderDisplayed());
	}

	@Then("User clicks on the SearchBy dropdown {string}")
	public void user_clicks_on_the_search_by_dropdown(String Option) throws InterruptedException {
		Hooks.locationPage.clickLocationdropdown();
	    Thread.sleep(2000);
	    Hooks.driver.navigate().refresh();
	    Thread.sleep(2000);
	}

	@Given("User click on the Filter button")
	public void user_click_on_the_filter_button() throws InterruptedException {
	    Hooks.locationPage.clickLocFilterBtn();
	    Thread.sleep(3000);
	}

	@Then("the user is able to view the header {string}")
	public void the_user_is_able_to_view_the_header(String string) {
	    assertTrue(Hooks.locationPage.islocationheaderDisplayed());
	}

	@Then("User selects ine of the checkbox")
	public void user_selects_ine_of_the_checkbox() {
	    Hooks.locationPage.clickFiltercheckbox();
	}

	@Then("User clicks on the Apply Filter button")
	public void user_clicks_on_the_apply_filter_button() throws InterruptedException {
	    Hooks.locationPage.clickApplyfilter();
	}


}
