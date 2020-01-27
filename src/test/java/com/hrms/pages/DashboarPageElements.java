package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboarPageElements extends CommonMethods{
	@FindBy (linkText = "Leave")
	public WebElement leaveLnk;
	
	@FindBy (linkText = "Leave List")
	public WebElement leaveListLnk;
	
	@FindBy (linkText = "PIM")
	public WebElement pimLnk;
	
	@FindBy (linkText = "Add Employee")
	public WebElement addEmpLnk;
	
	
	public DashboarPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
