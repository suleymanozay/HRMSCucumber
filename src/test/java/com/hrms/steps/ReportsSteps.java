package com.hrms.steps;

import org.junit.Assert;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.ReportPageElements;
import com.hrms.utils.CommonMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsSteps extends CommonMethods{
	ReportPageElements reports;
	
	
	@Given("I navigated to the Reports Page")
	public void i_navigated_to_the_Reports_Page() {
		DashboardPageElements dashBoard=new DashboardPageElements();
		dashBoard.navigateToReports();
	}

	@When("I enter invalid report")
	public void i_enter_invalid_report() {
	reports=new ReportPageElements();
	sendText(reports.reportNameSearch, "is there any report");
	}

	@When("I click search button")
	public void i_click_search_button() {
		click(reports.srchBtn);
	 
	}

	@Then("I see no record found message")
	public void i_see_no_record_found_message() {
		Assert.assertEquals("No Records Found message is not displayed", reports.resultTable.getText(), "No Records Found");
	}

	@When("I enter valid report")
	public void i_enter_valid_report() throws InterruptedException  {
		reports=new ReportPageElements();
		Thread.sleep(2000);
		reports.addNewReport("Employees");
		sendText(reports.reportNameSearch, "Employees");
		click(reports.srchBtn);
	   }

	@Then("I see the search report is displayed")
	public void i_see_the_search_report_is_displayed() {
		reports.tableSearch("Employees");
	   
	}


}
