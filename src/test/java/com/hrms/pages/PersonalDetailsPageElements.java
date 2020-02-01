package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;


public class PersonalDetailsPageElements {
	@FindBy(id="empPic")
	public WebElement empPicture;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement nameOnPicture;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement personalId;
	
	@FindBy(id="personal_txtEmpFirstName")
	public WebElement firstName;
	
	@FindBy(id="personal_txtEmpMiddleName")
	public WebElement middleName;
	
	@FindBy(id="personal_txtEmpLastName")
	public WebElement lastName;
	
	@FindBy(id="btnSave")
	public WebElement edit_saveBtn;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement driverLicense;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement expiratDate;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement ssn;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement sin;
	
	@FindBy(xpath = "//label[contains(@for,'personal_optGender')]")
	public List<WebElement> gender;
	
	@FindBy(id="personal_optGender_1")
	public WebElement male;
	
	@FindBy(id="personal_optGender_1")
	public WebElement female;
	
	
	@FindBy(id="personal_cmbMarital")
	public WebElement maritialStatus;
	
	@FindBy(id="personal_txtOtherID")
	public WebElement otherId;
	
	@FindBy(id="personal_cmbNation")
	public WebElement nationaly;
	
	@FindBy(id="personal_DOB")
	public WebElement date_birth;
	
	
	
	
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}