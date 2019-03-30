package com.testing.appium;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {

	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;
	
	public void startServer(String ip, int port) {
		// Start the server with the builder on Windows Machine
		service  =AppiumDriverLocalService.buildService( new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")) .withAppiumJS(new File("C:\\Users\\megha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress(ip).usingPort(port));
		service.start();
		
		System.out.println("Appium server started @ " + ip + ":" + port);
	}

	
	public void stopServer(int port) {
		if (checkIfServerIsRunnning(port)) {
			service.stop();
			System.out.println("Appium server stopped");
		} else {
			System.out.println("Appium server stopped");
		}

	}

	public boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public URL getUrl() {
		return service.getUrl();
	}

}
