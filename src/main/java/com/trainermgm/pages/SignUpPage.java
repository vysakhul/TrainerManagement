package com.trainermgm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trainermgm.constants.AutomationConstants;
import com.trainermgm.utilities.DropdownListChecker;
import com.trainermgm.utilities.PageScroller;

public class SignUpPage {
	
	WebDriver driver;
	
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
	
	@FindBy(id="skillSet")
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
	private WebElement imgpicker;
	
	@FindBy(xpath="//small[normalize-space()='Add your photo']")
	private WebElement errImgpicker;
	
	@FindBy(xpath="//span[@class='dropdown-btn']")
	private WebElement coursebtn;
	
	@FindBy(xpath="//li[@class='multiselect-item-checkbox']")
	private List<WebElement> courses;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//small[contains(text(),'Password must contain atleast 1 capital letter,1 s')]")
	private WebElement errPass;
	
	@FindBy(id="re_password")
	private WebElement repass;
	
	@FindBy(id="error")
	private WebElement errRepass; 
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//ul[@class='social']")
	private List<WebElement> socials;
	
	@FindBy(xpath="//footer[@id='footer']")
	public WebElement footer;
	
	@FindBy(xpath="//div[@class='dropdown-list']")
	private WebElement ddlist;
	
	
	
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setName(String fname)
	{
		name.sendKeys(fname);
	}
	
	public void setEmail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void setPhone(String mob)
	{
		phone.sendKeys(mob);
	}
	
	public void setAddress(String addr)
	{
		address.sendKeys(addr);
	}
	
	public void setQualification(String qualif)
	{
		qual.sendKeys(qualif);
	}
	
	public void setSkill(String skillset)
	{
		skill.sendKeys(skillset);
	}
	
	public void setCompany(String com)
	{
		company.sendKeys(com);
	}
	
	public void setDesignation(String des)
	{
		desig.sendKeys(des);
	}
	
	public void setPhoto(String imgloc)
	{
		imgpicker.sendKeys(imgloc);
	}
	
	public void setPass(String password)
	{
		pass.sendKeys(password);
	}
	
	public void setRepass(String password)
	{
		repass.sendKeys(password);
	}
	
	public void clickSignup()
	{
		submitbtn.click();
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
	
	public String getImgPickerError()
	{
		return errImgpicker.getText();
	}
	
	public String getPasswordError()
	{
		return errPass.getText();
	}
	
	public String getRePassError()
	{
		return errRepass.getText();
	}
	
//	public Boolean getCourseList() throws InterruptedException
//	{
//		int counter = 0;
//		Boolean listStatus = true;
//		int actLen = courses.size();
//		int expLen = AutomationConstants.COURSES.length;
//		if(actLen == expLen)
//		{
//			coursebtn.click();
//			PageScroller.scrollIntoView(driver, ddlist);
//			for(String str: AutomationConstants.COURSES)
//			{
//				for(int i=0;i<courses.size();i++)
//				{
//					if(str.equals(courses.get(i).getText()))
//					{
//						counter = counter+1;
//					}
//				}
//			}
//			if(counter != expLen)
//			{
//				listStatus = false;
//			}
//		} else listStatus = false;
//		
//		return listStatus;
//	}
	
	public Boolean getCourseList() throws InterruptedException
	{
		Boolean courseListStatus = DropdownListChecker.getMultiListStatus(driver, courses, coursebtn, AutomationConstants.COURSES);
		return courseListStatus;
	}
	
	public void setCourse(String...choices) throws InterruptedException
	{
		coursebtn.click();
		PageScroller.scrollIntoView(driver, ddlist);
		for(String choice: choices)
		{
			for(int i=0;i<courses.size();i++)
			{
				if(choice.equals(courses.get(i).getText()))
				{
					courses.get(i).click();
				}
			}
		}
	}
	
}
