package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.hrms.utils.APIConstants;

public class TaskAPI {
	private static RequestSpecification request;
	private static Response respone;
	
	@Given("user calls getAllEmployees API to retrieve all employees")
	public void user_calls_getAllEmployees_API_to_retrieve_all_employees() {
		request=given().header("Content-Type", "application/json").headers("Authorization",SyntaxAPIAuthenticationSteps.token );
	   
	}

	@When("User retrieves response for getAllEmployees API")
	public void user_retrieves_response_for_getAllEmployees_API() {
		respone=request.when().get(APIConstants.GET_ALL_EMPLOYEES_URI);
		respone.prettyPrint();
	}

	@Then("status code is {int} for getAllEmployees API")
	public void status_code_is_for_getAllEmployees_API(Integer int1) {
		
		respone.then().assertThat().statusCode(int1);
	  
	}

	@Then("user validates all employees are successfuly retrieving")
	public void user_validates_all_employees_are_successfuly_retrieving() {
		JSONObject json=new JSONObject(respone.prettyPrint());
		JSONArray array=json.getJSONArray("Employee");
		if (array.length()>0) {
			System.out.println("All employees retrieved" );
			}else {
				System.out.println("All employees NOT retrieved" );
			}
	   System.out.println("There are "+ array.length()+ " employees");
	}
	@Given("user calls jobTitle.php API to retrieve all jobs")
	public void user_calls_jobTitle_php_API_to_retrieve_all_jobs() {
		request=given().header("Content-Type", "application/json").header("Authorization",SyntaxAPIAuthenticationSteps.token);
	   
	}

	@When("User retrieves response for jobTitle API")
	public void user_retrieves_response_for_jobTitle_API() {
		respone=request.when().get(APIConstants.GET_ALL_JOB_TITLES_URI);
		respone.prettyPrint();

	}

	@Then("status code is {int} for jobTitle API")
	public void status_code_is_for_jobTitle_API(Integer int1) {
		respone.then().assertThat().statusCode(int1);
	   
	}

	@Then("user validates all jobs are successfuly retrieving")
	public void user_validates_all_jobs_are_successfuly_retrieving() {
		JSONObject json = new JSONObject(respone.prettyPrint());
		JSONArray array = json.getJSONArray("Job Title List");
		for (int i = 0; i <= array.length() - 1; i++) {
			System.out.println(array.get(i));
			if (i == 0) {
				Assert.assertEquals("Cloud Architect", array.get(i));
			}else if(i==1) {
				Assert.assertEquals("Cloud Consultant", array.get(i));
			}else if(i==2) {
				Assert.assertEquals("Cloud Product and Project Manager", array.get(i));
			}else if(i==3) {
				Assert.assertEquals("IT Analyst", array.get(i));
			}else if(i==4) {
				Assert.assertEquals("Network Administrator", array.get(i));
			}else if(i==5) {
				Assert.assertEquals("IT Support Manager", array.get(i));
			}else if(i==6) {
				Assert.assertEquals("Data Quality Manager", array.get(i));
			}else if(i==7) {
				Assert.assertEquals("Database Administrator", array.get(i));
			}
		}
		Assert.assertEquals(19, array.length());
		System.out.println(array.length());

	}

	@Given("user calls employeeStatus.php  API to retrieve all employee status")
	public void user_calls_employeeStatus_php_API_to_retrieve_all_employee_status() {
		request=given().header("Content-Type", "application/json").header("Authorization",SyntaxAPIAuthenticationSteps.token);
	}

	@When("User retrieves response for employeeStatus API")
	public void user_retrieves_response_for_employeeStatus_API() {
		respone=request.when().get(APIConstants.GET_EMPLOYE_STATUS_URI);
		respone.prettyPrint();
	}

	@Then("user validates allemployee status are successfuly retrieving")
	public void user_validates_allemployee_status_are_successfuly_retrieving() {
		JSONObject json = new JSONObject(respone.prettyPrint());
		JSONArray array = json.getJSONArray("Employee Status List");
		for (int i = 0; i <= array.length() - 1; i++) {
			System.out.println(array.get(i));
			
			if (i == 0) {
				Assert.assertEquals("Employee", array.get(i));
			}else if(i==1) {
				Assert.assertEquals("Worker", array.get(i));
			}else if(i==2) {
				Assert.assertEquals("Self-Employee", array.get(i));
			}else if(i==3) {
				Assert.assertEquals("Independent contractor", array.get(i));
			}else if(i==4) {
				Assert.assertEquals("Freelance", array.get(i));
			}else if(i==5) {
				Assert.assertEquals("Zero hours contract", array.get(i));
			}else if(i==6) {
				Assert.assertEquals("Gig economy", array.get(i));
			}else if(i==7) {
				Assert.assertEquals("Self-employe", array.get(i));
			}
		}
		Assert.assertEquals(9, array.length());
		System.out.println(array.length());

	
	}


}
