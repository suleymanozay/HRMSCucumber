package com.hrms.pages;

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
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}