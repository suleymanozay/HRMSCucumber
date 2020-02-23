package com.hrms.steps;

import java.util.Map;
import java.util.List;
import org.junit.Assert;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	
	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

	}
	 
	@Given("I navigated to Add Employe Page")
	public void i_navigated_to_Add_Employe_Page() {

		dahsboard.navigateToAddEmployee();
	}

	@When("I add {string}, {string}  and {string}")
	public void i_add_and(String fName, String mName, String lName) {

		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		empId = addEmp.empId.getText();
	}

	@When("I click Save")
	public void i_click_Save() {
		click(addEmp.saveBtn);
	}

	@Then("I verify Employee has been succesfully added")
	public void i_verify_Employee_has_been_succesfully_added() {

		Assert.assertEquals("Employee is NOT being added", pdetails.personalId.getText(), empId);
	}

	@Then("I verify Employee with {string}, {string} and {string} is displayed")
	public void i_verify_Employee_with_and_is_displayed(String string, String string2, String string3) {
		
		Assert.assertEquals("Employee first name is not displayed", pdetails.firstName.getAttribute("value"), string);
		Assert.assertEquals("Employee middle name is not displayed", pdetails.middleName.getAttribute("value"),
				string2);
		Assert.assertEquals("Employee last name is not displayed", pdetails.lastName.getAttribute("value"), string3);

	}

	@When("I delete employee id")
	public void i_delete_employee_id() {

		addEmp.empId.clear();
	}

	@Then("I see verify Employee witout id is being added")
	public void i_see_verify_Employee_witout_id_is_being_added() {
		Assert.assertEquals("Employee witout id is NOT  being added", addEmp.empId.getAttribute("value"), "");

	}

	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
		Assert.assertEquals("Required message is NOT  displayed", addEmp.firstNErrmsg.getText(), "Required");
		Assert.assertEquals("Required message is NOT  displayed", addEmp.lastNameErrmsg.getText(), "Required");
	}

	@When("I add firstName, middleName and last name")
	public void i_add_firstName_middleName_and_last_name() {

		sendText(addEmp.firstName, "Salamon");
		sendText(addEmp.middleName, "jr");
		sendText(addEmp.lastName, "Salamonn");
	}

	@When("I click on create login checkbox")
	public void i_click_on_create_login_checkbox() {
		click(addEmp.createLoginDetails);
	}

	@When("I enter username, password and confirm password")
	public void i_enter_username_password_and_confirm_password() {
		sendText(addEmp.username, "salamonozay");
		sendText(addEmp.userPassword, "syntax@1234");
		sendText(addEmp.confirmUserPassword, "syntax@1234");
	}

	@When("I click save")
	public void i_click_save() {
		jsClick(addEmp.saveBtn);
	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {

		List<Map<String, String>> empDetailsList = empDetails.asMaps();
		for (Map<String, String> map : empDetailsList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
		}
	}

	@When("i click on Edit")
	public void i_click_on_Edit() {

		click(pdetails.edit_saveBtn);
	}

	@Then("I am able to modify Employe Details")
	public void modifyEmployeDetails(DataTable modifyEmpDetail) throws InterruptedException {
		List<Map<String, String>> modifyList = modifyEmpDetail.asMaps();
		for (Map<String, String> map : modifyList) {
			sendText(pdetails.driverLicense, map.get("DriverLicense"));
			sendText(pdetails.expiratDate, map.get("ExpirationDate"));
			sendText(pdetails.ssn, map.get("SSN"));
			sendText(pdetails.sin, map.get("SIN"));
			clickRadio(pdetails.gender, map.get("Gender"));
			selectDdValue(pdetails.maritialStatus, map.get("MaritialStatus"));
			selectDdValue(pdetails.nationaly, map.get("Nationality"));
			sendText(pdetails.date_birth, map.get("DOB"));
			click(pdetails.edit_saveBtn);
			Thread.sleep(1500);
			takeScreenshot("modify");
			click(pdetails.edit_saveBtn);
		}

	}

}
