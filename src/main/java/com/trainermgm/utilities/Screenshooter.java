package com.trainermgm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Screenshooter {
	
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd @ HH.mm").format(new Date());
    }

	
	public static void getFullScreenshot(WebDriver driver) throws InterruptedException
	{
	PageScroller.scollToTop(driver);
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	
	File trg = new File(".\\screenshots\\FullScreen_"+timestamp()+".png");
    try {
		FileHandler.copy(src, trg);
    } catch (IOException exception) {
		exception.printStackTrace();
    }
	}
	
	public static void getScreenshotOfEle(WebDriver driver, WebElement ele) throws InterruptedException
	{
	PageScroller.scrollIntoView(driver, ele);
	File src = ele.getScreenshotAs(OutputType.FILE);
	
	File trg = new File(".\\screenshots\\ScreenshotofElement_"+timestamp()+".png");
    try {
		FileHandler.copy(src, trg);
    } catch (IOException exception) {
		exception.printStackTrace();
    }
	}
}

