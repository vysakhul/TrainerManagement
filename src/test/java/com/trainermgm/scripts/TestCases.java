package com.trainermgm.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.trainermgm.constants.AutomationConstants;
import com.trainermgm.pages.AdminHome;
import com.trainermgm.pages.LoginPage;
import com.trainermgm.utilities.ExcelUtility;


public class TestCases extends TestBase{
	LoginPage objLogin;
	AdminHome objAdmin;
	@Test(priority=1, description= "Login attempt with valid credentials")
	public void verifyValidLogin() throws IOException, InterruptedException{
		objLogin = new LoginPage(driver); 
		String username = ExcelUtility.getCellData("Logins", 0, 0);
		String password = ExcelUtility.getCellData("Logins", 0, 1);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		adminHomeWait();
		String expUrl = AutomationConstants.ADMINHOMEPAGEURL;
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		
	}
}
