package com.trainermgm.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.trainermgm.constants.AutomationConstants;
import com.trainermgm.utilities.DropdownListChecker;
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
	
	@FindBy(xpath="//body[1]/app-root[1]/app-admindash[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/select[1]")
	private WebElement empTypeDd;
	
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
	
	
	
	
	public int rowFinder(String email) throws InterruptedException
	{
		int counter = 0;
		int row = 0;
		for(int i=0;i<emailCol.size();i++)
		{
			System.out.println("Checking row: "+i);
			if(emailCol.get(i).getText().equals(email))
			{
			row = i;
			counter = counter +1;
			break;
			}
		}
		if(counter!=0)
		{
		return row;
		}
		else return -1;
	}
	
	public Boolean trainerStatus(String email) throws InterruptedException
	{
		int counter = 0;
		for(int i=0;i<emailCol.size();i++)
		{
			System.out.println("Checking row: "+i);
			if(emailCol.get(i).getText().equals(email))
			{
			counter = counter +1;
			break;
			}
		}
		if(counter!=0)
		{
		return true;
		}
		else return false;
	}
	
	public void trainerApproval(String email, String empType, String choice) throws InterruptedException 
	{
		int eleRow = rowFinder(email);
		if(eleRow != -1)
		{
		PageScroller.scrollIntoView(driver, approveBtn.get(eleRow-1));  //to adjust for navBar
		Select eType = new Select(adminHomeEmpType.get(eleRow));
		eType.selectByVisibleText(empType);
		if(choice.equals("Approve"))
		{
			approveBtn.get(eleRow).click();
		}
		else if(choice.equals("Reject"))
		{
			rejectBtn.get(eleRow).click();
		}
		}
		else
		{
			System.out.println("Trainer not found");
		}
	}
	

	public Boolean empTypeListStatus() throws InterruptedException
	{
		Boolean listStatus = DropdownListChecker.getListStatus(driver, empTypeDd, AutomationConstants.EMP_TYPES);
		return listStatus;
	}
	
	
	public void waitforPage()
	{
		Waiter.waitForEle(driver, adminHomeTable, 10);
	}
	
}
