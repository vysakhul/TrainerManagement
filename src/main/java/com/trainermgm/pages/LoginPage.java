package com.trainermgm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="floatingInput")
	private WebElement username;
	
	@FindBy(id="floatingPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='w-100 btn btn-lg btn-primary']")
	private WebElement login;
	
	
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
	
}
