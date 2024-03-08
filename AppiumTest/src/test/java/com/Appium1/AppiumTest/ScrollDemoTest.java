package com.Appium1.AppiumTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemoTest extends Base {

	@Test
	public void scrollTest(){
	
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
	//1. Scroll until View an element
	//scrollToElement("WebView");
	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	
	//2. Scroll as long as App has Elements
	scrollToEnd();
	
	}
}
