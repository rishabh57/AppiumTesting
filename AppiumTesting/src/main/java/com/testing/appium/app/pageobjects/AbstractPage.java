package com.testing.appium.app.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

	AppiumDriver<MobileElement> driver;

	// Constructor initiate page elements
	public AbstractPage(AppiumDriver<?> driver) {
		// PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	
}
