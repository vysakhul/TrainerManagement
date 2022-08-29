package com.trainermgm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	private WebElement homeNav;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginNav;
	
	@FindBy(xpath="//a[normalize-space()='Sign Up/Enroll']")
	private WebElement signupNav;
	
	@FindBy(xpath="//span[@class='carousel-control-next-icon']")
	private WebElement sliderRt;
	
	@FindBy(xpath="//span[@class='carousel-control-prev-icon']")
	private WebElement sliderLt;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickHome()
	{
		homeNav.click();
	}
	
	public  void clickLogin()
	{
		loginNav.click();
	}
	
	public void clickSignup()
	{
		signupNav.click();
	}
	
	public void sliderNext()
	{
		sliderRt.click();
	}
	
	public void sliderPrev()
	{
		sliderLt.click();
	}
}
