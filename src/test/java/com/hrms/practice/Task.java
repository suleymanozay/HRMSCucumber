package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Task {
	String dbUsername = "syntax_hrm";

	String dbPassword = "syntaxhrm123";

	String dbURL = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";

	@Test
	public void task() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		Statement statement = conn.createStatement();

		ResultSet rset = statement.executeQuery("select * from ohrm_job_title");
		List<String> jobList = new ArrayList<>();

		String data;
		while (rset.next()) {
			jobList.add(rset.getString("job_title"));

		}

		for (String string : jobList) {
			System.out.println(string);
		}
		rset.close();
		statement.close();
		conn.close();
	}
}