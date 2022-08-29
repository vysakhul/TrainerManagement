package com.trainermgm.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import com.trainermgm.utilities.Waiter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	public static Properties prop = null;
	public static void configLoad()
	{
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources" + "/config.properties");
		prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	@BeforeTest
	public void onSetup()
	{
		configLoad();
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	

}
