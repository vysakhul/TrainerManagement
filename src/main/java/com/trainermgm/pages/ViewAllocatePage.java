package com.trainermgm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllocatePage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Type to search']")
	private WebElement search;
	
	@FindBy(xpath="//th")
	private WebElement heading;
	
	@FindBy(xpath="//tbody//td[1]")
	private List<WebElement> idCol;
	
	@FindBy(xpath="//tbody//td[2]")
	private List<WebElement> nameCol;
	
	@FindBy(xpath="//tbody//td[3]")
	private List<WebElement> courseCol;
	
	@FindBy(xpath="//tbody//td[4]")
	private List<WebElement> batchCol;
	
	@FindBy(xpath="//tbody//td[5]")
	private List<WebElement> timeCol;
	
	@FindBy(xpath="//tbody//td[6]")
	private List<WebElement> startDateCol;
	
	@FindBy(xpath="//tbody//td[7]")
	private List<WebElement> endDateCol;
	
	@FindBy(xpath="//tbody//td[8]")
	private List<WebElement> venueCol;
	
	public ViewAllocatePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchById(String id)
	{
		search.sendKeys(id);
	}
}
