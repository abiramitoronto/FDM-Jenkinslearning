package com.fdmgroup.POMScripts;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.Pages.SignInPage;


import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
@RunWith(Suite.class)
@SuiteClasses({
	
	SignInTest.class
	
})
public class Runner {
	static DriverUtilities driverUtilities;
	static WebDriver driver;
	static SignInPage signinpage;
	
 
	@BeforeAll
	public static void init() {
		
		
		//setting up the driver
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		
		//page initialization
		signinpage = new SignInPage(driver);
		
		
		driver.manage().window().maximize();
 
	}
	
	
	@AfterAll
	public static void tearDown() {
		
		driver.quit();
		
	}

}

