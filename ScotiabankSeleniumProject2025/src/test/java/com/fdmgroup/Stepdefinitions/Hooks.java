package com.fdmgroup.Stepdefinitions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.Pages.LocationPage;
import com.fdmgroup.Pages.SearchPage;
import com.fdmgroup.Pages.SignInPage;

import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {
	
	static DriverUtilities driverUtilities;
	static WebDriver driver;
	static SignInPage signinpage;
	static LocationPage locationPage;
	static SearchPage searchPage;
	
 
	@BeforeAll
	public static void init() {
		
		
		//setting up the driver
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		
		//page initialization
		signinpage = new SignInPage(driver);
		locationPage = new LocationPage(driver);
		searchPage= new SearchPage(driver);
		
		driver.manage().window().maximize();
 
	}
	
	
	@AfterAll
	public static void tearDown() {
		
		driver.quit();
		
	}

}
