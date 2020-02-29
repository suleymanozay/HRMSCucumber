package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import com.hrms.utils.APIConstants;

public class GETOneEmployeeAPISteps {
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls getOneEmployee API")
	public void user_calls_getOneEmployee_API() {
		request=given().header("Content-Type", "application/json").header("Authorization", SyntaxAPIAuthenticationSteps.token)
		.param("employee_id", POSTCreateEmployeeAPI.employee_ID);
	   
	}

	@When("User retrieves response for getOneEmployee API")
	public void user_retrieves_response_for_getOneEmployee_API() {
		response=request.when().get(APIConstants.GET_ONE_EMPLOYE_URI);
		response.prettyPrint();

	}

	@Then("status code is {int} for getOneEmployee API")
	public void status_code_is_for_getOneEmployee_API(int int1) {
		response.then().assertThat().statusCode(int1);
	
	}

	@Then("user validates created employee exist")
	public void user_validates_created_employee_exist() {
		response.then().body("employee[0].employee_id", equalTo(POSTCreateEmployeeAPI.employee_ID));
		
		JsonPath jsonPathEvaluator=response.jsonPath();
		
		String actualyEmployee_ID=jsonPathEvaluator.get("employee[0].employee_id");
		System.out.println("Actual Employee ID "+ actualyEmployee_ID);
		try {
		Assert.assertEquals("Verifying Employee IDs", POSTCreateEmployeeAPI.employee_ID, actualyEmployee_ID);
		}catch (AssertionError e) {
			System.out.println("Employee IDs DO NOT MATCH");
		}
		System.out.println("Employe IDs MATCH ");
		
	  
	}

}
