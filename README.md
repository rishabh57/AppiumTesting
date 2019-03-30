# AppiumTesting

# Mobile Automation for Android App

This test automation framework is a generic automation framework which has reusable components and currently being used to automate the given android app. This framework is scalable to  iOS app as well.

#Pre-requisites

You'll need to install

    Download and install Java 8 from https://www.oracle.com/technetwork/java/javase/downloads/index.html
		Set up JAVA_HOME environment variable with value ‘C:\Program Files\Java\jdk1.8.0_45'
		Set path variable with value 'C:Program Files\Java\jdk1.8.0_45\bin‘.
	Download Android Studio from https://developer.android.com/studio/#Other
		Launch Android studio and start a project
		Choose default options while creating a project
		Select AVD manager and create an AVD with name Nexus_5X with oreo version
		Set ANDROID_HOME enviornment variable with value C:\Users\<user_name>\AppData\Local\Android\Sdk
		Check emulators from directory C:\Users\<user_name>\AppData\Local\Android\Sdk\emulators  using command prompt emulator.exe -list-avds
		Launch emulator from same directory using command prompt: emulator.exe @Nexus_5X
	Download nodeJs v 8.12.0 from https://nodejs.org/en/download/
		Go to command prompt and type node -v
	Install appium using npm module from command : npm install -g appium
	Download Microsoft .NET framework 4.5 from https://www.microsoft.com/en-in/download/details.aspx?id=30653
	Eclipse IDE.
    Maven plugin in Eclipse
    TestNG plugin in Eclipse.
	
	
	
#How to build	

	1. Clone repository from https://github.com/rishabh57/AppiumTesting.git
	2. Import project as existing Maven Project
	3. change AppiumServer.java file with appiumjs path (new File("C:\\Users\\<user_name>\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js
	3. Right click on pom.xml and run as clean install
	
#To run test, go to testng.xml and right click and run as TESTNG suite.

	#Description about Automation code
		1. pageObjects directory contains Page objects java files and their actions in respective file.
		2. util directory contains utiltity and driver related methods.
		3. Tests directory containes test cases java files.
		4. resources directory contains test data.
		5. pom.xml contains dependencies information.
		6. testng.xml contains test classes to execute.
        
# AppiumTesting
