package com.trainermgm.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.trainermgm.constants.AutomationConstants;
import com.trainermgm.pages.AdminHome;
import com.trainermgm.pages.AllocatePage;
import com.trainermgm.pages.HomePage;
import com.trainermgm.pages.LoginPage;
import com.trainermgm.pages.NavHelper;
import com.trainermgm.pages.SignUpPage;
import com.trainermgm.pages.TrainerProfilePage;
import com.trainermgm.pages.ViewAllocatePage;
import com.trainermgm.utilities.ExcelUtility;
import com.trainermgm.utilities.PageScroller;
import com.trainermgm.utilities.Screenshooter;


public class TestCases extends TestBase{
	
	LoginPage objLogin;
	AdminHome objAdmin;
	SignUpPage objSignup;
	HomePage objHome;
	AllocatePage objAllocate;
	ViewAllocatePage objView;
	NavHelper objNav;
	TrainerProfilePage objTrainer;
	
	@BeforeMethod
	public void createObj()
	{
		objHome = new HomePage(driver);
		objLogin = new LoginPage(driver); 
		objNav = new NavHelper(driver);
		objSignup = new SignUpPage(driver);
		objAdmin = new AdminHome(driver);
		objAllocate = new AllocatePage(driver);
		objView = new ViewAllocatePage(driver);
		objTrainer = new TrainerProfilePage(driver);
	}
	
	@Test(priority=1, description= "Confirm Page accessibility", enabled=true)
	public void verifySignUpAccess_REQ01_T1() throws InterruptedException
	{
		objHome.clickLogin();
		String expUrl = AutomationConstants.LOGIN_PAGE_URL;
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		Screenshooter.getFullScreenshot(driver);
		objHome.clickSignup();
		expUrl = AutomationConstants.SIGNUP_PAGE_URL;
		actUrl = driver.getCurrentUrl();
		Screenshooter.getFullScreenshot(driver);
		Assert.assertEquals(expUrl, actUrl);
		objHome.clickHome();
		expUrl = AutomationConstants.HOME_PAGE_URL;
		actUrl = driver.getCurrentUrl();
		Screenshooter.getFullScreenshot(driver);
		Assert.assertEquals(expUrl, actUrl);	
		
	}
	
	@Test(priority=2, description= "Login attempt with valid credentials", enabled=true)
	public void adminValidLogin_REQ01_T2() throws IOException, InterruptedException 
	{
		objNav.clickLoginNav();
		String username = ExcelUtility.getCellData("Logins", 1, 1);
		String password = ExcelUtility.getCellData("Logins", 1, 2);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		objNav.waitForPage();
		String expUrl = AutomationConstants.ADMIN_HOMEPAGE_URL;
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		
	}
	
	@Test(priority=3, description= "Trainer login attempt with valid credentials", enabled=true)
	public void trainerValidLogin_REQ01_T3() throws IOException, InterruptedException 
	{
		objNav.clickLoginNav();
		String username = ExcelUtility.getCellData("Logins", 2, 1);
		String password = ExcelUtility.getCellData("Logins", 2, 2);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		objNav.waitForPage();
		String expUrl = AutomationConstants.TRAINER_HOMEPAGE_URL;
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);	
	}
	
	@Test(priority=4, description= "Login button status verification", enabled=true)
	public void trainerValidLogin_REQ01_T4() throws IOException, InterruptedException 
	{
		objNav.clickLoginNav();
		String username = ExcelUtility.getCellData("Logins", 1, 1);
		String password = ExcelUtility.getCellData("Logins", 1, 2);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		Boolean btnStatus = objLogin.LoginBtnStatus();
		Assert.assertEquals(true, btnStatus);
	}
	
	@Test(priority=5, description= "Check if error message displayed for invalid field entries", enabled=true)
	public void mailBoxValidation_REQ01_T5() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		String username = ExcelUtility.getCellData("TestData", 0, 1);
		objLogin.setUsername(username);
		objLogin.setPassword("");	
		objLogin.setUsername("");
		String expErr = ExcelUtility.getCellData("Errors", 1, 1);
		String actErr = objLogin.getUsernameError();
		Assert.assertEquals(expErr, actErr);
		expErr = ExcelUtility.getCellData("Errors", 2, 1);
		actErr = objLogin.getPasswordError();
		Assert.assertEquals(expErr, actErr);	
	
	}
	
	@Test(priority=6, description= "Login attempt with invalid credentials", enabled=true)
	public void invalidLogin_REQ01_T6() throws IOException, InterruptedException 
	{
		objNav.clickLoginNav();
		String username = ExcelUtility.getCellData("Logins", 3, 1);
		String password = ExcelUtility.getCellData("Logins", 3, 2);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		String expErr = ExcelUtility.getCellData("Errors", 3, 1);
		String actErr = objLogin.getInvalidLoginError();
		Assert.assertEquals(expErr, actErr);	
	}
	
	@Test(priority=7, description= "Login button status verification", enabled=true)
	public void buttonStatus_REQ01_T7() throws IOException, InterruptedException 
	{
		objNav.clickLoginNav();
		String username = ExcelUtility.getCellData("Logins", 1, 1);
		objLogin.setUsername(username);
		Boolean btnStatus = objLogin.LoginBtnStatus();
		Assert.assertEquals(btnStatus, false);
	}
	
	@Test(priority=8, description= "Login button status verification", enabled=true)
	public void buttonStatus_REQ01_T8() throws IOException, InterruptedException 
	{
		objNav.clickLoginNav();
		String password = ExcelUtility.getCellData("Logins", 1, 2);
		objLogin.setPassword(password);
		Boolean btnStatus = objLogin.LoginBtnStatus();
		Assert.assertEquals(btnStatus, false);
	}
	
	@Test(priority=9, description="Valid SignUp page automation", enabled=true)
	public void validSignUp_REQ02_T1() throws InterruptedException, IOException
	{
		objNav.clickSignupNav();
		objSignup.setName(ExcelUtility.getCellData("FieldInputs", 3, 1));
		objSignup.setEmail(ExcelUtility.getCellData("FieldInputs", 4, 1));
		objSignup.setPhone(ExcelUtility.getCellData("FieldInputs", 5, 1));
		objSignup.setAddress(ExcelUtility.getCellData("FieldInputs", 6, 1));
		objSignup.setQualification(ExcelUtility.getCellData("FieldInputs", 7, 1));
		objSignup.setSkill(ExcelUtility.getCellData("FieldInputs", 8, 1));
		objSignup.setCompany(ExcelUtility.getCellData("FieldInputs", 9, 1));
		objSignup.setDesignation(ExcelUtility.getCellData("FieldInputs", 10, 1));
		objSignup.setPhoto(System.getProperty("user.dir") + "/images" + "/photo.jpeg");
		objSignup.setCourse(ExcelUtility.getCellData("FieldInputs", 12, 1), ExcelUtility.getCellData("FieldInputs", 12, 2));
		objSignup.setPass(ExcelUtility.getCellData("FieldInputs", 13, 1));
		objSignup.setRepass(ExcelUtility.getCellData("FieldInputs", 14, 1));
		objSignup.clickSignup();
		String msg = driver.switchTo().alert().getText();
		Assert.assertEquals(AutomationConstants.REGSUCCESS, msg);
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=10, description="Valid SignUp page automation", enabled=true)
	public void invalidSignUp_REQ02_T2() throws InterruptedException, IOException
	{
		objNav.clickSignupNav();
		objSignup.setName(ExcelUtility.getCellData("FieldInputs", 18, 1));
		objSignup.setEmail(ExcelUtility.getCellData("FieldInputs", 19, 1));
		objSignup.setPhone(ExcelUtility.getCellData("FieldInputs", 20, 1));
		objSignup.setAddress(ExcelUtility.getCellData("FieldInputs", 21, 1));
		objSignup.setQualification(ExcelUtility.getCellData("FieldInputs", 22, 1));
		objSignup.setSkill(ExcelUtility.getCellData("FieldInputs", 23, 1));
		objSignup.setCompany(ExcelUtility.getCellData("FieldInputs", 24, 1));
		objSignup.setDesignation(ExcelUtility.getCellData("FieldInputs", 25, 1));
		objNav.pressTab();
		objSignup.setPass(ExcelUtility.getCellData("FieldInputs", 28, 1));
		objSignup.setRepass(ExcelUtility.getCellData("FieldInputs", 29, 1));
		objSignup.setPass("");
		String actErr = objSignup.getNameError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 6, 1), actErr);
		actErr = objSignup.getMailError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 7, 1), actErr);
		actErr = objSignup.getPhoneError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 8, 1), actErr);
		actErr = objSignup.getAddressError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 9, 1), actErr);
		actErr = objSignup.getQualifError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 10, 1), actErr);
		actErr = objSignup.getSkillError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 11, 1), actErr);
		actErr = objSignup.getCompanyError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 12, 1), actErr);
		actErr = objSignup.getDesigError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 13, 1), actErr);
		actErr = objSignup.getImgPickerError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 14, 1), actErr);
		actErr = objSignup.getPasswordError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 15, 1), actErr);
		actErr = objSignup.getRePassError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 16, 1), actErr);
	}
	
	@Test(priority=11, description="Verify if all courses are listed in the drop down during sign up", enabled=true)
	public void verifyCourseDropdown_REQ02_T3() throws InterruptedException
	{
		objHome.clickSignup();
		Boolean listStatus = objSignup.getCourseList();
		Assert.assertEquals(true, listStatus);
	}
	
	@Test(priority=12, description="Verify the Approve functionality of new enrolled Trainers", enabled=true)
	public void verifyTrainerApproval_REQ03_T2() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.waitForPage();
		objAdmin.trainerApproval(ExcelUtility.getCellData("FieldInputs", 33, 1), ExcelUtility.getCellData("FieldInputs", 34, 1), 
				"Approve");
		Boolean status = objAdmin.trainerStatus(ExcelUtility.getCellData("FieldInputs", 33, 1));
		Assert.assertEquals(status, false);
	}
	
	@Test(priority=13, description="Confirm trainer added to Allocate list", enabled=true)
	public void confirmTrainerApproval_REQ03_T4() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.clickAllocateNav();
		objNav.waitForPage();
		Assert.assertEquals(objAllocate.trainerSearch(ExcelUtility.getCellData("FieldInputs", 39, 1)), false);
		
	}
	
	@Test(priority=14, description="Confirm if all expected options available in Emp Type drop down", enabled=true)
	public void verifyEmpTypeDropdown_REQ03_T5() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.waitForPage();
		Boolean listStatus=objAdmin.empTypeListStatus();
		Assert.assertEquals(true, listStatus);
	}
	
	@Test(priority=15, description="Verify the Reject functionality of new enrolled Trainers", enabled=true)
	public void verifyTrainerRejection_REQ03_T6() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.waitForPage();
		objAdmin.trainerApproval(ExcelUtility.getCellData("FieldInputs", 37, 1), ExcelUtility.getCellData("FieldInputs", 34, 1), 
				"Reject");
		Boolean trainerStatus = objAdmin.trainerStatus(ExcelUtility.getCellData("FieldInputs", 33, 1));
		Assert.assertEquals(false, trainerStatus);
		
	}
	
	@Test(priority=16, description="Confirm if Trainer able to edit profile information", enabled=true)
	public void trainerProfileEdit_REQ3_T9() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.trainerLogin();
		objTrainer.clickEditBtn();
		objTrainer.waitForFields();
		String actURL = driver.getCurrentUrl(); 
		Assert.assertEquals(actURL, AutomationConstants.TRAINER_PROFILE_EDIT_URL);
		//Page shows random behavior each time
		objTrainer.setName(ExcelUtility.getCellData("FieldInputs", 43, 1));
		objTrainer.setEmail(ExcelUtility.getCellData("FieldInputs", 44, 1));
		objTrainer.setPhone(ExcelUtility.getCellData("FieldInputs", 45, 1));
		objTrainer.setAddress(ExcelUtility.getCellData("FieldInputs", 46, 1));
		objTrainer.setQualif(ExcelUtility.getCellData("FieldInputs", 47, 1));
		objTrainer.setSkill(ExcelUtility.getCellData("FieldInputs", 48, 1));
		objTrainer.setCompany(ExcelUtility.getCellData("FieldInputs", 49, 1));
		objTrainer.setDesignation(ExcelUtility.getCellData("FieldInputs", 50, 1));
		objTrainer.clickSave();	
		String saveEmail = objTrainer.getEmail();
		Assert.assertEquals(saveEmail, ExcelUtility.getCellData("FieldInputs", 44, 1));
		String savePhone = objTrainer.getPhone();
		Assert.assertEquals(savePhone, ExcelUtility.getCellData("FieldInputs", 45, 1));
		String saveAddress = objTrainer.getAddress();
		Assert.assertEquals(saveAddress, ExcelUtility.getCellData("FieldInputs", 46, 1));
		String saveQual = objTrainer.getQual();
		Assert.assertEquals(saveQual, ExcelUtility.getCellData("FieldInputs", 47, 1));
		String saveSkill = objTrainer.getSkill();
		Assert.assertEquals(saveSkill, ExcelUtility.getCellData("FieldInputs", 48, 1));
		String saveCompany = objTrainer.getCompany();
		Assert.assertEquals(saveCompany, ExcelUtility.getCellData("FieldInputs", 49, 1));
		String saveDesig = objTrainer.getDesig();
		Assert.assertEquals(saveDesig, ExcelUtility.getCellData("FieldInputs", 50, 1));
	}
	
	@Test(priority=16, description="Verify if trainer profile edit fields show proper error messages", enabled=true)
	public void trainerProfileInvalidEdit_REQ3_T11() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.trainerLogin();
		objTrainer.clickEditBtn();
		objTrainer.waitForFields();
		String actURL = driver.getCurrentUrl(); 
		Assert.assertEquals(actURL, AutomationConstants.TRAINER_PROFILE_EDIT_URL);
		//Page shows random behavior each time
		Thread.sleep(5000);
		objTrainer.setName(ExcelUtility.getCellData("FieldInputs", 54, 1));
		String actErr = objTrainer.getNameError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 20, 1), actErr);
		objTrainer.setEmail(ExcelUtility.getCellData("FieldInputs", 55, 1));
		actErr = objTrainer.getMailError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 21, 1), actErr);
		objTrainer.setPhone(ExcelUtility.getCellData("FieldInputs", 56, 1));
		actErr = objTrainer.getPhoneError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 22, 1), actErr);
		objTrainer.setAddress(ExcelUtility.getCellData("FieldInputs", 57, 1));
		actErr = objTrainer.getAddressError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 23, 1), actErr);
		objTrainer.setQualif(ExcelUtility.getCellData("FieldInputs", 58, 1));
		actErr = objTrainer.getQualifError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 24, 1), actErr);
		objTrainer.setSkill(ExcelUtility.getCellData("FieldInputs", 59, 1));
		actErr = objTrainer.getSkillError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 25, 1), actErr);
		objTrainer.setCompany(ExcelUtility.getCellData("FieldInputs", 60, 1));
		actErr = objTrainer.getCompanyError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 26, 1), actErr);
		objTrainer.setDesignation(ExcelUtility.getCellData("FieldInputs", 61, 1));
		actErr = objTrainer.getDesigError();
		Assert.assertEquals(ExcelUtility.getCellData("Errors", 27, 1), actErr);
		Boolean saveBtnStatus = objTrainer.btnStatus();
		Assert.assertEquals(saveBtnStatus, false);

	}
	
	
	@Test(priority=1, description="Allocate trainer for a session", enabled=true)
	public void verifyAllocate_REQ05_T1() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.clickAllocateNav();
		objNav.waitForPage();
		objAllocate.allocateEmployee(ExcelUtility.getCellData("FieldInputs", 65, 1));
		PageScroller.scollToTop(driver);
		Thread.sleep(2500);
		String id = objAllocate.checkID();
		Assert.assertEquals(id, ExcelUtility.getCellData("FieldInputs", 65, 1));
		objAllocate.setCourseid(ExcelUtility.getCellData("FieldInputs", 66, 1));
		objAllocate.setBatchid(ExcelUtility.getCellData("FieldInputs", 67, 1));
		objAllocate.setTime(ExcelUtility.getCellData("FieldInputs", 68, 1));
		objAllocate.setStartDate(ExcelUtility.getCellData("FieldInputs", 69, 1));
		objAllocate.setEndDate(ExcelUtility.getCellData("FieldInputs", 70, 1));
		objAllocate.setVenue(ExcelUtility.getCellData("FieldInputs", 71, 1));
		objAllocate.clickAllocateTrainer();
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, AutomationConstants.ALLOCATE_PAGE_URL);
		
	}
	
	@Test(priority=1, description="Verify if proper error messages are displayed for invalid entries", enabled=true)
	public void verifyAllocateTrainerfields_REQ05_T3() throws InterruptedException, IOException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.clickAllocateNav();
		objNav.waitForPage();
		objAllocate.allocateEmployee(ExcelUtility.getCellData("FieldInputs", 65, 1));
		PageScroller.scollToTop(driver);
		Thread.sleep(2500);
		String id = objAllocate.checkID();
		Assert.assertEquals(id, ExcelUtility.getCellData("FieldInputs", 65, 1));
		String actErr = objAllocate.getEndDateError();
		Assert.assertEquals(actErr, ExcelUtility.getCellData("Errors", 35, 1));
		objAllocate.clickCourseid();
		objAllocate.clickBatchid();
		actErr = objAllocate.getCourseIdError();
		Assert.assertEquals(actErr, ExcelUtility.getCellData("Errors", 31, 1)); //trigger prev. err.
		objAllocate.setTime("");
		actErr = objAllocate.getBatchIdError();
		Assert.assertEquals(actErr, ExcelUtility.getCellData("Errors", 32, 1));
		objAllocate.setStartDate("");
		actErr = objAllocate.getTimeError();
		Assert.assertEquals(actErr, ExcelUtility.getCellData("Errors", 33, 1));
		objAllocate.setVenue("");
		actErr = objAllocate.getStartDateError();
		Assert.assertEquals(actErr, ExcelUtility.getCellData("Errors", 34, 1));
		objAllocate.setTime("");
		actErr = objAllocate.getVenueError();
		Assert.assertEquals(actErr, ExcelUtility.getCellData("Errors", 36, 1));
		Boolean status = objAllocate.allocateBtnStatus();
		Assert.assertEquals(false, status);
	}
	
	@Test(priority=1, description="Verify if Course ID drop down lists all options", enabled=true)
	public void verifyCourseIdList_REQ05_T5() throws InterruptedException, IOException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.clickAllocateNav();
		objNav.waitForPage();
		objAllocate.allocateEmployee(ExcelUtility.getCellData("FieldInputs", 65, 1));
		PageScroller.scollToTop(driver);
		Thread.sleep(2500);
		Boolean status = objAllocate.courseIdListCheck();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=1, description="Verify if Batch ID drop down lists all options", enabled=true)
	public void verifyBatchIdList_REQ05_T6() throws InterruptedException, IOException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.clickAllocateNav();
		objNav.waitForPage();
		objAllocate.allocateEmployee(ExcelUtility.getCellData("FieldInputs", 65, 1));
		PageScroller.scollToTop(driver);
		Thread.sleep(2500);
		Boolean status = objAllocate.batchIdListCheck();
		Assert.assertEquals(status, true);
	}
	

	@Test(priority=1, description="Allocate trainer for different sessions at same time and confirm system blocking", enabled=true)
	public void verifyAllocate_REQ06_T1() throws IOException, InterruptedException
	{
		objNav.clickLoginNav();
		objLogin.adminLogin();
		objNav.clickAllocateNav();
		objNav.waitForPage();
		objAllocate.allocateEmployee(ExcelUtility.getCellData("FieldInputs", 65, 1));
		PageScroller.scollToTop(driver);
		Thread.sleep(2500);
		String id = objAllocate.checkID();
		Assert.assertEquals(id, ExcelUtility.getCellData("FieldInputs", 65, 1));
		objAllocate.setCourseid(ExcelUtility.getCellData("FieldInputs", 66, 1));
		objAllocate.setBatchid(ExcelUtility.getCellData("FieldInputs", 67, 1));
		objAllocate.setTime(ExcelUtility.getCellData("FieldInputs", 68, 1));
		objAllocate.setStartDate(ExcelUtility.getCellData("FieldInputs", 69, 1));
		objAllocate.setEndDate(ExcelUtility.getCellData("FieldInputs", 70, 1));
		objAllocate.setVenue(ExcelUtility.getCellData("FieldInputs", 71, 1));
		objAllocate.clickAllocateTrainer();
		objNav.waitForPage();
		objAllocate.allocateEmployee(ExcelUtility.getCellData("FieldInputs", 65, 1));
		PageScroller.scollToTop(driver);
		Thread.sleep(2500);
		id = objAllocate.checkID();
		Assert.assertEquals(id, ExcelUtility.getCellData("FieldInputs", 65, 1));
		objAllocate.setCourseid(ExcelUtility.getCellData("FieldInputs", 74, 1));
		objAllocate.setBatchid(ExcelUtility.getCellData("FieldInputs", 75, 1));
		objAllocate.setTime(ExcelUtility.getCellData("FieldInputs", 76, 1));
		objAllocate.setStartDate(ExcelUtility.getCellData("FieldInputs", 77, 1));
		objAllocate.setEndDate(ExcelUtility.getCellData("FieldInputs", 78, 1));
		objAllocate.setVenue(ExcelUtility.getCellData("FieldInputs", 79, 1));
		Boolean status = objAllocate.allocateBtnStatus();
		Assert.assertEquals(false, status);
		
	}
	
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(2000); //app too slow to adapt to sudden close after test 
		driver.close();
	}
}


