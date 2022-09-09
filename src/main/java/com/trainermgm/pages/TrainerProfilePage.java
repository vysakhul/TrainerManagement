package com.trainermgm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trainermgm.utilities.PageScroller;
import com.trainermgm.utilities.Waiter;

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
	
	@FindBy(xpath="//tr[1]/td[2]")
	private List<WebElement> mainPhone;
	
	@FindBy(xpath="//tr[2]/td[2]")
	private List<WebElement> mainEmail;
	
	@FindBy(xpath="//tr[3]/td[2]")
	private List<WebElement> mainAddress;
	
	@FindBy(xpath="//tr[4]/td[2]")
	private List<WebElement> mainQual;
	
	@FindBy(xpath="//tr[5]/td[2]")
	private List<WebElement> mainCompany;
	
	@FindBy(xpath="//tr[6]/td[2]")
	private List<WebElement> mainDesig;
	
	@FindBy(xpath="//tr[7]/td[2]")
	private List<WebElement> mainSkill;
	
	@FindBy(xpath="//table")
	private WebElement table;
	
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
	
	@FindBy(xpath="//form")
	private WebElement form;
	
	
	public TrainerProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickEditBtn()
	{
		editProfileBtn.click();
	}
	
	public String getPhone() throws InterruptedException
	{
		Waiter.waitForValue(mainPhone);
		return mainPhone.get(0).getText();
	}
	
	public String getEmail() throws InterruptedException
	{
		Waiter.waitForValue(mainEmail);
		return mainEmail.get(0).getText();
	}
	
	public String getAddress() throws InterruptedException
	{
		Waiter.waitForValue(mainAddress);
		return mainAddress.get(0).getText();
	}
	
	public String getQual() throws InterruptedException
	{
		Waiter.waitForValue(mainQual);
		return mainQual.get(0).getText();
	}
	
	public String getCompany() throws InterruptedException
	{
		Waiter.waitForValue(mainCompany);
		return mainCompany.get(0).getText();
	}
	
	public String getDesig() throws InterruptedException
	{
		Waiter.waitForValue(mainDesig);
		return mainDesig.get(0).getText();
	}
	
	public String getSkill() throws InterruptedException
	{
		Waiter.waitForValue(mainSkill);
		return mainSkill.get(0).getText();
	}
	
//	public void waitForValue(List<WebElement> ele) throws InterruptedException
//	{
//		while(ele.get(0).getText().isEmpty())
//		{
//			Thread.sleep(100);
//		}
//	}
//	
//	public void waitForValue(WebElement ele) throws InterruptedException
//	{
//		while(ele.getText().isEmpty())
//		{
//			Thread.sleep(100);
//		}
//	}
	
	
	
	
	// TRAINER PROFILE EDIT
	
	public void waitForAutoContent() throws InterruptedException
	{
		Waiter.waitForValue(name);
	}
	
	public void setName(String nm) throws InterruptedException
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
	
	public void clickSave() throws InterruptedException
	{
		PageScroller.scrollIntoView(driver, editBtn);
		editBtn.click();
	}
	
	public String getNameError()
	{
		return errName.getText();
	}
	
	public String getMailError()
	{
		return errEmail.getText();
	}
	
	public String getPhoneError()
	{
		return errPhone.getText();
	}
	
	public String getAddressError()
	{
		return errAddress.getText();
	}
	
	public String getQualifError()
	{
		return errQual.getText();
	}
	
	public String getSkillError()
	{
		return errSkill.getText();
	}
	
	public String getCompanyError()
	{
		return errCompany.getText();
	}
	
	public String getDesigError()
	{
		return errDesig.getText();
	}
	
	public Boolean btnStatus() throws InterruptedException
	{
		PageScroller.scrollIntoView(driver, editBtn);
		return editBtn.isEnabled();
	}
	
	public void waitForFields()
	{
		Waiter.waitForEle(driver, form, 10);
	}
}
