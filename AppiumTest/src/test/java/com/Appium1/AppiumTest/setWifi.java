package com.Appium1.AppiumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class setWifi extends Base {

	
	
	@Test
	public void setWifiTest() {
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	//xpath://tagName(@attribute='value') Or //tagName
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
    driver.findElement(By.id("android:id/checkbox")).click();
    driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
    driver.findElement(By.id("android:id/edit")).sendKeys("no1234");
    driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    
	}
}