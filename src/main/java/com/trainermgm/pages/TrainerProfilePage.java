package com.trainermgm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerProfilePage {
	WebDriver driver;
	
	//TRAINER PROFILE
	
	@FindBy(xpath="//button[normalize-space()='Edit Profile']")
	private WebElement editProfileBtn;
	
	@FindBy(xpath="//a[normalize-space()='My Profile']")
	private WebElement myProfileNav;
	
	@FindBy(xpath="//a[normalize-space()='My Allocation Details']")
	private WebElement myAllocationNav;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logoutNav;
	
	//EDIT PROFILE PAGE
	
	@FindBy(id="name")
	private WebElement name;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid name']")
	private WebElement errName;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid mail Id']")
	private WebElement errEmail;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid mobileNo']")
	private WebElement errPhone;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid address']")
	private WebElement errAddress;
	
	@FindBy(id="h_qualification")
	private WebElement qual;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid qualification']")
	private WebElement errQual;
	
	@FindBy(xpath="//input[@name='skillSet']")
	private WebElement skill;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid skills']")
	private WebElement errSkill;
	
	@FindBy(id="company_name")
	private WebElement company;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid company name']")
	private WebElement errCompany;
	
	@FindBy(id="designation")
	private WebElement desig;
	
	@FindBy(xpath="//small[normalize-space()='Enter valid designation']")
	private WebElement errDesig;
	
	@FindBy(id="img")
	private WebElement imagePicker;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement editBtn;
	
	
	public TrainerProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setName(String nm)
	{
		name.clear();
		name.sendKeys(nm);
	}
	
	public void setEmail(String em)
	{
		email.clear();
		email.sendKeys(em);
	}
	
	public void setPhone(String mob)
	{
		phone.clear();
		phone.sendKeys(mob);
	}
	
	public void setAddress(String addr)
	{
		address.clear();
		address.sendKeys(addr);
	}
	
	public void setQualif(String qualif)
	{
		qual.clear();
		qual.sendKeys(qualif);
	}
	
	public void setSkill(String skillset)
	{
		skill.clear();
		skill.sendKeys(skillset);
	}
	
	public void setCompany(String comp)
	{
		company.clear();
		company.sendKeys(comp);
	}
	
	public void setDesignation(String des)
	{
		desig.clear();
		desig.sendKeys(des);
	}
	
	public void setPhoto(String imglink)
	{
		imagePicker.sendKeys(imglink);
	}
	
	public void clickSave()
	{
		editBtn.click();
	}
}
