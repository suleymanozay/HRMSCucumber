package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static  io.restassured.RestAssured.*;

public class SampleApiTests {
	
	//@Test
	public void getAllJobTitles() {

		
		Response response=RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAyNCwidXNlcklkIjoiMTg1In0.dIUAVDlCh9DpaFygNl8DEERkJEposnG_I1zdqPTfh60")
		.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");
		
		response.prettyPrint();
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
		
	}
	//@Test
	public void getOneEmployee() {
		Response response=RestAssured.given().param("employee_id", "3552").contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAyNCwidXNlcklkIjoiMTg1In0.dIUAVDlCh9DpaFygNl8DEERkJEposnG_I1zdqPTfh60")
		.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
		
		response.prettyPrint();
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
		
	}
	/*
	 * Task:
	 * getAllEmployeeStatuses
	 * pretty print
	 * 
	 */
	//@Test
	public void getAllEmployeeStatuses() {
		Response response=RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAyNCwidXNlcklkIjoiMTg1In0.dIUAVDlCh9DpaFygNl8DEERkJEposnG_I1zdqPTfh60")
		.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");
		
		response.prettyPrint();
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
		
	}

	@Test
	public void createEmployee() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI4MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODAyNCwidXNlcklkIjoiMTg1In0.dIUAVDlCh9DpaFygNl8DEERkJEposnG_I1zdqPTfh60")
				.body("{\n    \"emp_firstname\": \"Suley1maqnNew\",\n    \"emp_lastname\": \"OZA1Y\",\n    \"emp_middle_name\": \"Senior\",\n    \"emp_gender\": \"2\",\n    \"emp_birthday\": \"1974-02-19\",\n    \"emp_status\": \"Worker\",\n    \"emp_job_title\": \"Cloud Consultant\"\n}")

				.when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");

		response.prettyPrint();

		int actualStatusCode = response.getStatusCode();
		System.out.println(actualStatusCode);
		Assert.assertEquals(200, actualStatusCode);

	}
}
