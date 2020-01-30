package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ReportPageElements extends CommonMethods{
	@FindBy(id = "search_search")
	public WebElement reportNameSearch;
	
	@FindBy(name =  "_search")
	public WebElement srchBtn;
	
	@FindBy(name = "_reset")
	public WebElement resetBtn;
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addBtn;
	
	@FindBy(id = "btnDelete")
	public WebElement deleteBtn;
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td")
	public WebElement resullTable;
	
	@FindBy(id = "ohrmList_chkSelectRecord_5")
	public WebElement chkListSelect;
	
	@FindBy(id = "ohrmList_chkSelectAll")
	public WebElement selectAll;
	
	//add report
	
	@FindBy(id = "report_report_name")
	public WebElement reportName;
	
	@FindBy(id = "report_criteria_list")
	public WebElement selectCrit;
	
	@FindBy(id = "report_include_comparision")
	public WebElement selectCritInclude;
	
	@FindBy(id = "report_display_groups")
	public WebElement slctdisplayGrp;
	
	@FindBy(id = "report_display_field_list")
	public WebElement slctDisplayField;
	
	@FindBy(id = "btnAddConstraint")
	public WebElement slctCritAdd;
	
	@FindBy(id = "btnAddDisplayGroup")
	public WebElement displayGrpAdd;
	
	@FindBy(id="display_group_1")
	public WebElement checkBox1;
	
	@FindBy(id = "btnAddDisplayField")
	public WebElement displayFieldsAdd;
	
	@FindBy(id="display_group_2")
	public WebElement checkBox2;
		
	@FindBy(id="report_gender")
	public WebElement slctGender;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	@FindBy(id="employee_name_empName")
	public WebElement slctfieldEmpName;
	
	public void addNewReport(String rName) throws InterruptedException {
		Thread.sleep(1500);
		click(addBtn);
		Thread.sleep(1500);
		sendText(reportName, rName);
		Select select=new Select( selectCrit);
		select.selectByValue("employee_name");
		click(slctCritAdd);
		Select select1=new Select( selectCritInclude);
		select1.selectByVisibleText("Current Employees Only");
		sendText(slctfieldEmpName, "Kobe Kobe");
		Select select2=new Select(slctDisplayField);
		select2.selectByValue("display_field_9");
		click(displayFieldsAdd);
		click(checkBox1);
		click(saveBtn);
	
	}
	public void tableSearch(String reportsName) {
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
		for (WebElement webElement : rows) {
			if(webElement.equals(reportsName)) {
				System.out.println("Reporst is displayed");
			}else {
				System.out.println("Reporst is not displayed");
			}
		}
	}
	
	
	
	
	public ReportPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}


}
