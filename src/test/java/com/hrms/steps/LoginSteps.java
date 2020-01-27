package com.hrms.steps;

import org.junit.Assert;
import com.hrms.pages.LoginPageElements;
import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends CommonMethods{
	LoginPageElements login;
	@Given("I open browser and  navigated to HRMS")
	public void i_open_browser_and_navigated_to_HRMS() {
	  BaseClass.setUp();
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
	  login=new LoginPageElements();
	  sendText(login.userName, "Admin");
	  sendText(login.password, "Syntax@123");
	 
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	   click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
	  System.out.println("I am logged in");
	  	}

	@When("I enter valid  username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		login=new LoginPageElements();
		 sendText(login.userName, "Admin");
		 sendText(login.password, "kjdfbsk");
	}
	
	@Then("I see error message")
	public void i_see_error_message() {
	   boolean errMsg=login.errorMsg.isDisplayed();
	    Assert.assertTrue("Error msg is not display", errMsg);
	  
	   
	}
	@Then("I close browser")
	public void i_close_browser() {
		 tearDown();
	}


}