package com.trainermgm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trainermgm.utilities.Waiter;

public class NavHelper {
	WebDriver driver;
	
	@FindBy(xpath="//tbody/tr")
	private WebElement table;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	private WebElement homeNav;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginNav;
	
	@FindBy(xpath="//a[normalize-space()='Sign Up/Enroll']")
	private WebElement signupNav;

	@FindBy(xpath="//a[normalize-space()='My Profile']")
	private WebElement myProfileNav;
	
	@FindBy(xpath="//a[normalize-space()='My Allocation Details']")
	private WebElement myAllocationNav;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logoutNav;
	
	@FindBy(xpath="//a[@class='nav-link'][normalize-space()='Allocate']")
	private WebElement allocateNav;
	
	@FindBy(xpath="//a[normalize-space()='ViewAllocation']")
	private WebElement viewAllocationNav;
	
	public NavHelper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickHomeNav()
	{
		homeNav.click();
	}
	
	public void clickLoginNav()
	{
		loginNav.click();
	}
	
	public void clickSignupNav()
	{
		signupNav.click();
	}
	
	public void clickMyProfileNav()
	{
		myProfileNav.click();
	}
	
	public void clickMyAllocateNav()
	{
		myAllocationNav.click();
	}
	
	public void clickLogoutNav()
	{
		logoutNav.click();
	}
	
	public void clickAllocateNav()
	{
		allocateNav.click();
	}
	
	public void clickViewAllocationNav()
	{
		viewAllocationNav.click();
	}
	
	public void pressTab()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		
	}
	
	public void waitForPage()
	{
		Waiter.waitForEle(driver, table, 10);
	}
	
}
