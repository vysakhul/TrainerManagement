package com.trainermgm.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.trainermgm.constants.AutomationConstants;
import com.trainermgm.pages.AdminHome;
import com.trainermgm.pages.AllocatePage;
import com.trainermgm.pages.HomePage;
import com.trainermgm.pages.LoginPage;
import com.trainermgm.pages.NavHelper;
import com.trainermgm.pages.SignUpPage;
import com.trainermgm.pages.ViewAllocatePage;
import com.trainermgm.utilities.ExcelUtility;
import com.trainermgm.utilities.PageScroller;
import com.trainermgm.utilities.Screenshooter;


public class TestCases extends TestBase{
	
	LoginPage objLogin;
	AdminHome objAdmin;
	
	@Test(priority=1, description= "Login attempt with valid credentials", enabled=false)
	public void verifyValidLogin() throws IOException 
	{
		objLogin = new LoginPage(driver); 
		objAdmin = new AdminHome(driver);
		String username = ExcelUtility.getCellData("Logins", 1, 1);
		String password = ExcelUtility.getCellData("Logins", 1, 2);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();	
	}
	
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}


