package com.testing.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.appium.AppiumDriverSetup;
import com.testing.appium.app.pageobjects.LandingPage;
import com.testing.appium.utility.PropertiesUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class Sanity_Test {

	AppiumDriverSetup appiumSetup = null;
	AppiumDriver<MobileElement> driver = null;
	PropertiesUtil pu= new PropertiesUtil();

	@SuppressWarnings("deprecation")
	@Parameters({ "appiumServerUrl", "appiumPort", "platform",
			"platformVersion", "deviceName", "appPath" })
	@BeforeTest
	public void setUp(String appiumServerUrl, String appiumPort,
			String platform, String platformVersion, String deviceName,
			String appPath) {
		appiumSetup = new AppiumDriverSetup(appiumServerUrl, new Integer(
				appiumPort), platform, platformVersion, deviceName, appPath);
		appiumSetup.startAppiumServer();
		driver = appiumSetup.getMobileDriver();

	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Test(priority = 1)
	public void waitingButton() {
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("waitingButtonTestCD");
		el1.click();
		driver.navigate().back();
		Reporter.log("Test 1 passed.");
		
		
	}

	@Test(priority = 2, enabled = true)
	public void visibleButton() {
		
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("visibleButtonTestCD");
		el2.click();
		Reporter.log("Test 2 passed.");
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Test(priority = 3, enabled = true)
	public void showPopupWindowButton() {
		
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("showPopupWindowButtonCD");
		el3.click();
		(new TouchAction(driver)).tap(363, 649).perform();
		
		Reporter.log("Test 3 passed.");
	}
	
	@Test(priority = 4, enabled = true)
	public void touchTest() {
		
		MobileElement el4 = (MobileElement) driver.findElementById("io.selendroid.testapp:id/touchTest");
		el4.click();
		driver.navigate().back();
		
		Reporter.log("Test 4 passed.");
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		appiumSetup.stopAppiumDriver();
		appiumSetup.stopAppiumServer();
	}

}
