package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(linkText = "Leave")
	public WebElement leaveLnk;

	@FindBy(linkText = "Leave List")
	public WebElement leaveList;

	@FindBy(linkText = "PIM")
	public WebElement pim;

	@FindBy(linkText = "Add Employee")
	public WebElement addEmp;
	
	@FindBy(linkText = "Reports")
	public WebElement reportsLink;

	@FindBy(id = "welcome")
	public WebElement welcomeLnk;

	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void navigateToLeaveList() {
		jsClick(leaveLnk);
		jsClick(leaveList);
	}

	public void navigateToAddEmployee() {
		waitForClickability(pim);
		click(pim);
		waitForClickability(addEmp);
		click(addEmp);
	}
	public void navigateToReports() {
		click(pim);
		waitForClickability(reportsLink);
		click(reportsLink);
	}
}