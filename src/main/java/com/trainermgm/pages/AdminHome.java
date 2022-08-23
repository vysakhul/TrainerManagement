package com.trainermgm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminHome {
	
	WebDriver driver;
	public static String rejectBtn_Loc = "//a[text()='Reject']";
	@FindBy(xpath="//a[text()='Reject']")
	public static WebElement rejectBtn;
	
	public AdminHome(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickReject()
	{
		rejectBtn.click();
	}
	

	

}
