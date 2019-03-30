package com.testing.appium;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverSetup {

	AppiumDriver<MobileElement> mobileDriver;

	private AppiumServer appiumServer;
	private String appiumServerUrl;
	private int appiumServerPort;
	public String platform;
	private String platformVersion;
	private String deviceName;
	private String appPath;
	
	public AppiumDriverSetup(String appiumServerUrl, int appiumServerPort, String platform, String platformVersion, String deviceName, String appPath) {
		this.appiumServerUrl = appiumServerUrl;
		this.appiumServerPort = appiumServerPort;
		this.platform = platform;
		this.platformVersion = platformVersion;
		this.deviceName = deviceName;
		this.appPath = appPath;
		appiumServer = new AppiumServer();
	}
	
	public void startAppiumServer(){
		appiumServer.startServer(appiumServerUrl, appiumServerPort);
	}
	
	public void stopAppiumServer() {
		appiumServer.stopServer(appiumServerPort);
		System.out.println("Appium Server Stopped");
	}

	public AppiumDriver<MobileElement> getMobileDriver() {
//		startAppiumServer();
		try {
			if (platform.equalsIgnoreCase("android")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME ,  "UiAutomator2");
				cap.setCapability(MobileCapabilityType.APP, appPath);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
				mobileDriver = new AndroidDriver<MobileElement>(new URL(appiumServer.getUrl().toString()), cap);
		//		mobileDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				System.out.println("returning android driver");
//				mobileDriver = new AndroidDriver<MobileElement>(new URL("http://10.17.246.220:4444/wd/hub"), cap);
			}

			else if (platform.equalsIgnoreCase("ios")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME ,  "XCUITest");
				cap.setCapability(MobileCapabilityType.APP, appPath);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
				mobileDriver = new IOSDriver<MobileElement>(new URL(appiumServer.getUrl().toString()), cap);
				System.out.println("returning iOs driver");
//				mobileDriver = new IOSDriver<MobileElement>(new URL("http://10.17.246.220:4444/wd/hub"), cap);
				
				try{
					new WebDriverWait(mobileDriver, 10000).until(ExpectedConditions.alertIsPresent());
					mobileDriver.switchTo().alert().accept();
					System.out.println("Waiting for 2nd pop-up");
					Thread.sleep(5000);
					new WebDriverWait(mobileDriver, 10000).until(ExpectedConditions.alertIsPresent());
					mobileDriver.switchTo().alert().accept();
				}
				catch(Exception e) {
					System.out.println("Exception generated while handling pop-up on iOS");
				}
			}

			else {
				System.out.println("Wrong Choice: Enter android for AndroidDriver and ios for IOSDRiver");
			}
			mobileDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return mobileDriver;
		} catch (Exception e) {
			System.out.println("Could not initiate the driver. Exception--> " + e);
			return mobileDriver;
		}
	}

	public void stopAppiumDriver() {
		mobileDriver.quit();
		System.out.println("Mobile Driver Stopped");
	}
}
