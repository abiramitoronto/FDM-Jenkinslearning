package com.fdmgroup.script;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.utilities.DriverUtilities;

public class Test {
	
	public static void main(String[] args) {
		DriverUtilities driverUtilities =  DriverUtilities.getInstance();
		WebDriver driver = driverUtilities.getDriver();
	}

}
