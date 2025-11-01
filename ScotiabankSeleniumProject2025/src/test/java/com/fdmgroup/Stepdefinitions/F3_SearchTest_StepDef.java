package com.fdmgroup.Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fdmgroup.DataFile.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class F3_SearchTest_StepDef {
	

@Then("User search for the {string} in the search bar")
public void user_search_for_the_in_the_search_bar(String field) throws InterruptedException {
    Hooks.searchPage.enterSearchItem(field);
    Thread.sleep(3000);
}

@Then("User is able to click on the search button")
public void user_is_able_to_click_on_the_search_button() throws InterruptedException {
    Hooks.searchPage.clickSearchItemButton();
    Thread.sleep(5000);
}


@Then("User click on the exchang currency link")
public void user_click_on_the_exchang_currency_link() {
    Hooks.searchPage.exchangelinkd();
}

@Given("User Verify the foreign exchange rate header")
public void user_verify_the_foreign_exchange_rate_header() {
    assertTrue(Hooks.searchPage.isexchangeRateHeaderDisplayed());
}

@Then("the User is able to view the table")
public void the_user_is_able_to_view_the_table() {
    assertTrue(Hooks.searchPage.isviewTableDisplayed());
}
//
//@Then("the User is able to get the rates for country {string}")
//public void the_user_is_able_to_get_the_rates_for_country(String Country) {
//	assertEquals(Hooks.searchPage.enterRateandCountry(), DataFile.MyCountry);
//    
//}

}
