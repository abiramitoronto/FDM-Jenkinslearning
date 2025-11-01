package com.fdmgroup.Pages;



import java.security.cert.CollectionCertStoreParameters;
import java.util.List;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fdmgroup.DataFile.DataFile;
import com.google.common.collect.Table;

public class SearchPage {
static WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[contains(@id,'searchContainer')]//input[contains(@id,'header__search')]")
	private WebElement searchItem;
	
	@FindBy(xpath= "//div//button[contains(@id,'searchSubmitBtn')]")
	private WebElement clickSearchButton;
	
	
	@FindBy(xpath ="//a//h5[contains(text(),'Foreign Currency Exchange Rates | Scotiabank Canada')]")
	private WebElement clickExchangelink;
	
	@FindBy(xpath="//h1[contains(text(),'Foreign exchange rates')]")
	private WebElement exchangeRateHeader;
	
	@FindBy(xpath ="//div//table[contains(@class,'bns--table')]")
	private WebElement viewTable;
	
//	@FindBy(xpath ="//table[@class='bns--table']")
//	private WebElement rateandCountry;
//	
	
	public void enterSearchItem(String field) {
		searchItem.sendKeys(field);
	}
	
	public void clickSearchItemButton() {
		System.out.println("BeforeClass searchItem clickh");
		clickSearchButton.click();
		System.out.println("afterClass searchItem clickh");
	}

	

	
	public void exchangelinkd() {
		clickExchangelink.click();
	}
	
	public boolean isexchangeRateHeaderDisplayed() {
		return exchangeRateHeader.isDisplayed();
	}
	
	public boolean isviewTableDisplayed() {
		return viewTable.isDisplayed();
	}
//	
//	public String enterRateandCountry() {
//		List<WebElement> tableRows = rateandCountry.findElements(By.xpath(".//tr"));
//		
//		for (WebElement row : tableRows) {
//			List<WebElement> columns = row.findElements(By.xpath(".//td"));
//					
//					String tblCountry =  columns.get(1).getText();
//					System.out.println("TableCountry = " + tblCountry);
//					if (DataFile.MyCountry == tblCountry) {
//						return tblCountry;
//					}
//					
//					
//		}
//		return null;
//		
//	}
	
}
