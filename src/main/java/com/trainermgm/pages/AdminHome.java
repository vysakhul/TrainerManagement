package com.trainermgm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.trainermgm.utilities.PageScroller;
import com.trainermgm.utilities.Waiter;


public class AdminHome {
	
	WebDriver driver;
	
	public String adminHomeTable_Loc = "//tbody/tr";
	public String adminHomeTableRow_Loc = "//tbody/tr[1]/td";
	
	@FindBy(xpath="//tbody/tr")
	private WebElement adminHomeTable;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	private WebElement adminHomeNav;
	
	@FindBy(xpath="//a[@class='nav-link'][normalize-space()='Allocate']")
	private WebElement allocateNav;
	
	@FindBy(xpath="//a[normalize-space()='ViewAllocation']")
	private WebElement viewAllocationNav;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logoutNav;
	
	
	
	@FindBy(id="emptype")
	private List<WebElement> adminHomeEmpType;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	private List<WebElement> approveBtn;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	private List<WebElement> rejectBtn;
	
	@FindBy(xpath="//tbody//td[2]")
	private List<WebElement> emailCol;
	
	@FindBy(xpath="//th")
	private List<WebElement> headings;
	
	@FindBy(xpath="//nav[@class='navbar navbar-expand-lg navbar-dark bg-dark fixed-top']")
	private WebElement navBar;
	
	
	public AdminHome(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public int findNumberOfCols()
	{
		int cols = headings.size();
		return cols;
	}
	
	public void clickAdminHomeNav()
	{
		adminHomeNav.click();
	}
	
	public void clickAllocateNav()
	{
		allocateNav.click();
	}
	
	public void clickViewAllocationNav()
	{
		viewAllocationNav.click();
	}
	
	public void clickLogoutNav()
	{
		logoutNav.click();
	}
	
	
}
