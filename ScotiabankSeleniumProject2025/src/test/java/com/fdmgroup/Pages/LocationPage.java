	package com.fdmgroup.Pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



//import com.fdmgroup.stepdefinitions.Hooks;

public class LocationPage {
static WebDriver driver;
	
	public LocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//a//i[contains(@class,'icon-Icon_LocationPin')]")
	private WebElement LocationIcon;
	
	@FindBy(xpath = "//h1[contains(@class,'TextHeadlinestyle__Text-canvas-core__sc-rml86m-0 fJxvQv TextHeadline_size-36__mOH2D')]")
	private WebElement locationPageHeader;
	
	@FindBy(id = "searchBySelector")
	private WebElement locationDropdown;
	
	@FindBy(id = "searchBySelector")
	private WebElement clickDropdown;
	
	@FindBy(xpath = "//button[contains(@class,'TextButtonstyle__StyleTextButton-canvas-core__sc-1ssjpvn-0 gHhDoM TextButton__button TextButton_icon-margin_left__R48Sj')]")
	private WebElement clicklocationFilterButton;
	
	@FindBy(xpath = "//h2[contains(@class,'TextHeadlinestyle__Text-canvas-core__sc-rml86m-0 fjTKUY')]")
	private WebElement locationFilterheader;
	
	@FindBy(xpath = "(//span[contains(@class,'Checkboxstyle__CheckboxIconWrapper-canvas-core__sc-1p7p9fh-4 gFktfw Checkbox__span')])[2]")
	private WebElement FilterLocationCheckbox;
	
	@FindBy(xpath = "//button[contains(@id,'apply-button')]")
	private WebElement applyFilterButton;
	
	@FindBy(xpath = "//div//span[contains(@class,'NotificationBadge__count')]")
	private WebElement applyFilternofity;
	
	
	
	
	
	public boolean islocationiconDisplayed() {
		return LocationIcon.isDisplayed();
	}
	
	public void clicklocationIcon() {
		System.out.println("before");
		LocationIcon.click();
		System.out.println("afterclick");
	}
	
	public boolean islocationheaderDisplayed() {
		return locationPageHeader.isDisplayed();
	}
	
	public void clickLocationdropdown() throws InterruptedException {
		Select locationDropSelect = new Select(clickDropdown);
		locationDropSelect.selectByContainsVisibleText("Transit number");
		String location = locationDropSelect.getFirstSelectedOption().getText();
		Thread.sleep(3000);
		System.out.println("curr location: " + location);
		assertEquals("Transit number",location); 
		
//		locationDropSelect.selectByValue("LOCATION");
//		String location2 = locationDropSelect.getFirstSelectedOption().getText();
//		Thread.sleep(3000);
//		System.out.println("curr location: " + location2);
//		//assertEquals("LOCATION",location2); 
		clickDropdown.click();
	}
	
	public boolean islocationDropdownDisplayed() {
		return locationFilterheader.isDisplayed();
	}
	
	public void clickFiltercheckbox() {
		FilterLocationCheckbox.click();
	}
	
	public void clickLocFilterBtn() {
		clicklocationFilterButton.click();
	}
	
	public void clickApplyfilter() throws InterruptedException {
		Actions action = new Actions(driver);
        action.moveToElement(applyFilterButton).build().perform();
        Thread.sleep(3000);
        System.out.println("beforeclick");
        action.click(applyFilterButton).build().perform();
        System.out.println("afterclick");
	}
	
	public boolean isfilterNotificationDisplayed() {
		return applyFilternofity.isDisplayed();
	}
	
	
	
	
	

}
