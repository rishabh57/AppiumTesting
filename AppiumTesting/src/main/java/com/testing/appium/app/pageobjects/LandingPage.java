package com.testing.appium.app.pageobjects;

import org.openqa.selenium.WebElement;

import com.testing.appium.utility.PropertiesUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingPage extends AbstractPage {
	 
	PropertiesUtil pu= new PropertiesUtil();
	/*
	 * Constructor
	 */
	public LandingPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		 this.driver = driver;
	}

	/*
	 * Page Elements will be put here
	 */
	

	/*
	 * Actions on page elements will be put here
	 * 
	 */
	
}
