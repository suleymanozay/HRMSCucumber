package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

public class CreateEmployeeAPI {

	private static RequestSpecification request;
	private Response response;

	@Given("user calls createEmployee API")
	public void user_calls_createEmployee_API() {
		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.token);
	 request
				.body(CommonMethods.readJson(
						System.getProperty("user.dir") + "/src/test/resources/JSONFiles/createEmployees.json"));
					}

	@When("user retrieves response")
	public void user_retrieves_response() {
		response=request.when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");

	}

	@Then("status code is {int}")
	public void status_code_is(Integer int1) {
		//get("/status/check").then().assertThat().statusCode(int1);
	

	}

	@Then("user validates employee is created")
	public void user_validates_employee_is_created() {

	}

}
