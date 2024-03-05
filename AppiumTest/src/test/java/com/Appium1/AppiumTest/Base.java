package com.Appium1.AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		//run appium server automatically
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Jay Patel\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		
		//Create Capabilities
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Demo2");
		//options.setApp("D:\\Jay\\Eclipse\\AppiumTest\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		//Create object of the AndroidDriver/IOSDriver
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Object Locators: xpath, id, className, accessibilityId, androidUiautomator
		//xpath,id,className works same like selenium driver.findElement(By...)
		
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		/*
		driver.quit();
		service.stop();*/
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
