package com.hrms.steps;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

import com.hrms.utils.DbUtils;

import cucumber.api.java.en.Then;

public class DataBaseSteps extends DbUtils {

	@Then("I collect employee data from database")
	public void i_collect_employee_data_from_database() {

		createConnection();

	}

	@Then("I verify employee data is matched")
	public void i_verify_employee_data_is_matched() {

		String sqlQuery = "select employee_id from hs_hr_employees where employee_id=" + AddEmployeeSteps.empId + ";";

		List<Map<String, String>> list = storeDataFromDB(sqlQuery);
		
		Assert.assertFalse(list.isEmpty());//1. way simple verify

		for (Map<String, String> map : list) {// 2. way
			Collection<String> val = map.values();
			for (String map2 : val) {
				System.out.println(map2);
				Assert.assertEquals("Employe data is not matched", AddEmployeeSteps.empId, map2);
			}

		}

		closeResources();

	}

}
