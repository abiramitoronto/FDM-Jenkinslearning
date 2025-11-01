package com.fdmgroup.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	static WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className= "h--btn")
	private WebElement clickSignInButton;
	
	@FindBy(id= "signIn")
	private WebElement clickRegisterPagesignInButton;
	

	@FindBy(id = "usernameInput-input")
	private WebElement invaliduserNameorcardNumber;
	
	@FindBy(name = "password")
	private WebElement invalidpwd;
	
	
	@FindBy(id ="UsernameTextField__errors-usernameInput")
	private WebElement userNameorcardNumbererrorMessage;
	
	@FindBy(id ="PasswordTextField__errors-password")
	private WebElement passworderrorMessage;
	
	@FindBy(xpath ="(//div[1][contains(@class,'h--container header-config-container')])//a[1]/img[1][contains(@class,'desktop')]")
	private WebElement logo;
	
	@FindBy(linkText ="Click here to learn more")
	private WebElement canadaPostLink;
	
	@FindBy(tagName = "h2")
	private WebElement canadaPostHeader;
	
	@FindBy(xpath= "//span[@class='Checkboxstyle__CheckboxIconWrapper-canvas-core__sc-1p7p9fh-4 bnZxwK Checkbox__span']")
	private WebElement clickRemembermecheckbox;
	
	public void clicksigniinButton() {
		clickSignInButton.click();
	}
	
	public void clickRegsigniinButton() {
		clickRegisterPagesignInButton.click();
	}

	
	public void enterUsername(String username) {
		invaliduserNameorcardNumber.sendKeys(username);
		
	}
	
	public void enterPassword(String password) {
		invalidpwd.sendKeys(password);
	}
	
	public boolean isUsernameErrDisplayed() {
		return invaliduserNameorcardNumber.isDisplayed();
	}
	
	public boolean isPasswordErrDisplayed() {
		return invalidpwd.isDisplayed();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public void clickcadPostLink() {
		canadaPostLink.click();
	}
	
	public boolean isheaderDisplayed() {
		return canadaPostHeader.isDisplayed();
	}
	
	public void clickRemembercheckbox() {
		clickRemembermecheckbox.click();
	}
	


}
