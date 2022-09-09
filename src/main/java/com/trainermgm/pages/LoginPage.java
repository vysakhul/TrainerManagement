package com.trainermgm.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trainermgm.utilities.ExcelUtility;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="floatingInput")
	private WebElement username;
	
	@FindBy(xpath="//small[@class='text-danger']")
	private WebElement errUsername;
	
	@FindBy(id="floatingPassword")
	private WebElement password;
	
	@FindBy(xpath="//small[normalize-space()='Please enter a valid password']")
	private WebElement errPassword;
	
	@FindBy(xpath="//button[@class='w-100 btn btn-lg btn-primary']")
	private WebElement login;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement errInvalidLogin;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String strname)
	{
		username.sendKeys(strname);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public String getUsernameError()
	{
		return errUsername.getText();
	}
	
	public String getPasswordError()
	{
		return errPassword.getText();
	}
	
	public String getInvalidLoginError()
	{
		return errInvalidLogin.getText();
	}
	
	public Boolean LoginBtnStatus()
	{
		return login.isEnabled();
	}
	
	public void clearFields()
	{
		username.clear();
		password.clear();
	}
	
	public void adminLogin() throws IOException, InterruptedException
	{
		String username = ExcelUtility.getCellData("Logins", 1, 1);
		String password = ExcelUtility.getCellData("Logins", 1, 2);
		setUsername(username);
		setPassword(password);
		clickLogin();
	}
	
	public void trainerLogin() throws IOException, InterruptedException
	{
		String username = ExcelUtility.getCellData("Logins", 2, 1);
		String password = ExcelUtility.getCellData("Logins", 2, 2);
		setUsername(username);
		setPassword(password);
		clickLogin();
	}
}
