package com.testing.appium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	private Properties prop =  null;
	
	public PropertiesUtil() {
		prop  = new Properties();
	}
	
	public PropertiesUtil(String filePath) {
		prop =  new Properties();
		loadPropertiesFile(filePath);
	}
	
	public void loadPropertiesFile(String filePath){
		 try {
			 prop.load(new FileInputStream(filePath));
	        }
	        catch(Exception e) {
	        	System.out.println("Exception generated while reading properties file => "+filePath);
	        }
	}
	
	public void loadTestProperties() {
		try {
			 prop.load(new FileInputStream(new File("src/test/resources/testData.properties").getAbsolutePath()));
	        }
	        catch(Exception e) {
	        	System.out.println("Exception generated while reading properties file => testConfig.properties");
	        }
	}
	
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	public String getProperty(String key, String fileName){
		if(fileName.equalsIgnoreCase("testData.properties")) {
			loadTestProperties();
		}
		return prop.getProperty(key);
	}
	
	
	
}
