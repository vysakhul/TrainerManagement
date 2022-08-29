package com.trainermgm.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
	
	public static WebElement waitForEle(WebDriver driver, By locator, int timeout)
	{
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public static WebElement waitForEle(WebDriver driver, WebElement locator, int timeout)
	{
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		mywait.until(ExpectedConditions.visibilityOfAllElements(locator));
		return locator;
	}
}
