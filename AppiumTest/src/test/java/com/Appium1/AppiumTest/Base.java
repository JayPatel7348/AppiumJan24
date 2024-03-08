package com.Appium1.AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

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
	
	//Scroll to View an element
	public void scrollToElement(String ele)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ele\"));"));

	}
	
	//Scroll till the all elements 
	public void scrollToEnd() 
	{
	boolean canScrollMore;
	do {
	canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	    "left", 100, "top", 100, "width", 200, "height", 200,
	    "direction", "down",
	    "percent", 3.0
	));
	}while(canScrollMore);
	}
	
	//perform swipe
	public void swipeAction(WebElement firstImage,String swipedirection)
	{
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    	    "elementId", ((RemoteWebElement) firstImage).getId(),
			    "direction", swipedirection,
			    "percent", 0.75
			));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
