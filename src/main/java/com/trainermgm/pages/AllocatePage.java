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

public class AllocatePage {
	WebDriver driver;
	
	//ALLOCATE MAIN PAGE ELEMENTS
	
	@FindBy(xpath="//input[@placeholder='Type to search']")
	private WebElement search;
	
	@FindBy(xpath="//th")
	private List<WebElement> heading;
	
	@FindBy(xpath="//tbody/tr")
	private WebElement allocateTable;
	
	@FindBy(xpath="//tbody//td[1]")
	private List<WebElement> idCol;
	
	@FindBy(xpath="//tbody//td[2]")
	private List<WebElement> nameCol;
	
	@FindBy(xpath="//tbody//td[3]")
	private List<WebElement> emailCol;
	
	@FindBy(xpath="//tbody//td[4]")
	private List<WebElement> numberCol;
	
	@FindBy(xpath="//tbody//td[5]")
	private List<WebElement> courseCol;
	
	@FindBy(xpath="//tbody//td[6]")
	private List<WebElement> qualCol;
	
	@FindBy(xpath="//tbody//td[7]")
	private List<WebElement> skillCol;
	
	@FindBy(xpath="//tbody//td[8]")
	private List<WebElement> companyCol;
	
	@FindBy(xpath="//tbody//td[9]")
	private List<WebElement> desigCol;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	private List<WebElement> allocateBtn;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	private WebElement adminHomeNav;
	
	@FindBy(xpath="//a[@class='nav-link'][normalize-space()='Allocate']")
	private WebElement allocateNav;
	
	@FindBy(xpath="//a[normalize-space()='ViewAllocation']")
	private WebElement viewAllocationNav;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logoutNav;
	
	
	//ALLOCATE TRAINER PAGE ELEMENTS
	
	@FindBy(id="Unique_ID")
	private WebElement Id;
	
	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(id="emptype")
	private WebElement empType;
	
	@FindBy(id="courses")
	private WebElement courses;
	
	@FindBy(id="courseid")
	private WebElement courseid;
	
	@FindBy(xpath="//small[normalize-space()='Choose a course ID']")
	private WebElement errCourseid;
	
	@FindBy(id="batchid")
	private WebElement batchid;
	
	@FindBy(xpath="//small[normalize-space()='Choose a Batch ID']")
	private WebElement errBatchid; 
	
	@FindBy(id="scheduletime")
	private WebElement time;
	
	@FindBy(xpath="//small[normalize-space()='Select a time']")
	private WebElement errTime;
	
	@FindBy(id="startdate")
	private WebElement startdate;
	
	@FindBy(xpath="//small[normalize-space()='Select a date to start the course']")
	private WebElement errStartdate;
	
	@FindBy(id="enddate")
	private WebElement enddate;
	
	@FindBy(xpath="//small[normalize-space()='End date must be after start date']")
	private WebElement errEnddate;
	
	@FindBy(id="venue")
	private WebElement venue;
	
	@FindBy(xpath="//small[normalize-space()='Enter meet link/venue']")
	private WebElement errVenue;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement allocateTrainerBtn;
	
	public AllocatePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchBy(String srh)
	{
		search.sendKeys(srh);
	}
	
	public int rowFinder(String id) throws InterruptedException
	{
		int counter = 0;
		int row=0;
		for(int i=0;i<idCol.size();i++)
		{
			System.out.println("Checking row: "+i);
			if(idCol.get(i).getText().equals(id))
			{
			row = i;
			counter = counter + 1;
			break;
			}
		}
		if(counter!=0)
		{
		return row;
		}
		else return -1;
	}
	
	public Boolean trainerSearch(String id) throws InterruptedException
	{
		int tRow=0;
		tRow = rowFinder(id);
		if(tRow == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void allocateEmployee(String id) throws InterruptedException
	{
		int eleRow = rowFinder(id);
		if(eleRow != -1)
		{
		PageScroller.scrollIntoView(driver, allocateBtn.get(eleRow-1));
		
		for(int i=0;i<idCol.size();i++)
		{
			if(idCol.get(i).getText().equals(id))
			{
				allocateBtn.get(i).click();
				break;
			}
		}
		} else
		{
			System.out.println("Trainer not found");
		}
	}
	
	
//	public void allocateWait()
//	{
//		Waiter.waitForEle(driver, allocateTable, 10);
//	}

	
	
	////////////////////////////////////////////////////////////////////////
	//ALLOCATE TRAINER PAGE ELEMENTS
	////////////////////////////////////////////////////////////////////////
	
	public Boolean statusOfIdBox()
	{
		Boolean status = Id.isEnabled();
		return status;
	}
	
	public String checkID()
	{
		return Id.getAttribute("value");
	}
	
	public Boolean statusOfNameBox()
	{
		Boolean status = name.isEnabled();
		return status;
	}
	
	public Boolean statusOfEmpTypeBox()
	{
		Boolean status = empType.isEnabled();
		return status;
	}
	
	public Boolean statusOfCourseBox()
	{
		Boolean status = courses.isEnabled();
		return status;
	}
	
	public void setCourseid(String course)
	{
		Select sc = new Select(courseid);
		sc.selectByVisibleText(course);
	}
	
	public void clickCourseid()
	{
		courseid.click();
	}
	
	public void setBatchid(String batch)
	{
		Select sc = new Select(batchid);
		sc.selectByVisibleText(batch);
	}
	
	public void clickBatchid()
	{
		batchid.click();
	}
	
	public void setTime(String tm)
	{
		time.sendKeys(tm);
	}
	
	public void setStartDate(String start)
	{
		startdate.sendKeys(start);
	}
	
	public void setEndDate(String end)
	{
		enddate.sendKeys(end);
	}
	
	public void setVenue(String link)
	{
		venue.sendKeys(link);
	}
	
	public String getCourseIdError()
	{
		return errCourseid.getText();
	}
	
	public String getBatchIdError()
	{
		return errBatchid.getText();
	}
	
	public String getTimeError()
	{
		return errTime.getText();
	}
	
	public String getStartDateError()
	{
		return errStartdate.getText();
	}
	
	public String getEndDateError()
	{
		return errEnddate.getText();
	}
	
	public String getVenueError()
	{
		return errVenue.getText();
	}
	
	public void clickAllocateTrainer() throws InterruptedException
	{
		PageScroller.scrollIntoView(driver, allocateTrainerBtn);
		allocateTrainerBtn.click();
	}
	
	public Boolean allocateBtnStatus() throws InterruptedException
	{
		PageScroller.scrollIntoView(driver, allocateTrainerBtn);
		return allocateTrainerBtn.isEnabled();
	}
	
	public Boolean courseIdListCheck() throws InterruptedException
	{
		Boolean status = DropdownListChecker.getListStatus(driver, courseid, AutomationConstants.COURSE_ID);
		return status;
	}
	
	public Boolean batchIdListCheck() throws InterruptedException
	{
		Boolean status = DropdownListChecker.getListStatus(driver, batchid, AutomationConstants.BATCH_ID);
		return status;
	}
	
	
	
	
	
	
	
	
	
}
