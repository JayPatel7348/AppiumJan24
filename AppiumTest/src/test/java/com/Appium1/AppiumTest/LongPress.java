package com.Appium1.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class LongPress extends Base {

	@Test
	public void longpressTest()
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		WebElement longpressBtn=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	    
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) longpressBtn).getId(),"duration",2000));
		
		WebElement sampleMenu=driver.findElement(By.id("android:id/title"));
		String peopleText=sampleMenu.getText();
		Assert.assertEquals(peopleText, "Sample menu");
		
		Boolean display=sampleMenu.isDisplayed();
		Assert.assertTrue(display);
		
	}
}
