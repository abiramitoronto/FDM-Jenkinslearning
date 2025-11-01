package com.fdmgroup.POMScripts;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.DataFile.DataFile;
import com.fdmgroup.Pages.SignInPage;
import com.fdmgroup.Stepdefinitions.Hooks;

import com.fdmgroup.POMScripts.Runner;

import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.messages.types.Hook;

public class SignInTest {
	private WebDriver driver = Runner.driver;
	private SignInPage signInPage = Runner.signinpage;
	
//	static DriverUtilities driverUtilities;
//	static WebDriver driver;
	
//	@BeforeClass
//	public static void init() {
//		driverUtilities =  DriverUtilities.getInstance();
//		 driver = driverUtilities.getDriver();
//		 
//		 driver.manage().window().maximize();
//		
//	}
	
	@Test
	public void LoginTest() throws InterruptedException {
//		 Navigation
		  driver.navigate().to(DataFile.HomeUrl);
		
		
		SignInPage signinpage = new SignInPage(driver);
		
		signinpage.clicksigniinButton();
		System.out.println("bowmanville signin button");
		Thread.sleep(3000);
		//click signIn Button
//		WebElement clicksignInButton = signinpage.clicksignInButton();
//		if (clicksignInButton.isDisplayed()) {
//			clicksignInButton.click();
			
			signinpage.clickRegsigniinButton();
			System.out.println("Regsignin button");
			Thread.sleep(3000);
		
		//	assertEquals(alertMessage, Hooks.loginPage.getErrorAlert());
//		navigate to the loginpage
//		driver.navigate().to(DataFile.login);
//			Thread.sleep(3000);
		
		//Explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'layout login-page')]")));
		//enter emailID
//		    WebElement emailId = signinpage.enterUsername(username);
//			emailId.sendKeys(DataFile.emailID);
//			Thread.sleep(3000);
//		
//		//enter password
//			WebElement password = signinpage.password();
//			password.sendKeys(DataFile.password);
//			Thread.sleep(3000);
	}
	
//	 @AfterClass
//		public static void tearDown() {
//	    	 
//	    	 driver.quit();
//	    	 
//	     }

}
