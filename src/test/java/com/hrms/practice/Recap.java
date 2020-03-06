package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Recap {
	String dbUsername="syntax_hrm";
	
	String dbPassword="syntaxhrm123";
	
	String dbURL="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	@Test
	public void gettinConnected() throws SQLException {
		Connection con=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData=con.getMetaData();
		String dbName=dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		Statement st=con.createStatement();
		ResultSet rSet=st.executeQuery("select * from ohrm_skill");
		
		ResultSetMetaData rsetMetaData=rSet.getMetaData();
		
		int cols=rsetMetaData.getColumnCount();
		System.out.println(cols);
		String colName;
		for (int i = 1; i <=cols; i++) {
			colName=rsetMetaData.getColumnName(i);
			System.out.println(colName);
		}
		
		String id;
		String skill;
		while(rSet.next()) {
			id=rSet.getObject("id").toString();
			skill=rSet.getObject("name").toString();
			System.out.println(id +" = "+skill);
		}
		rSet.close();
		st.close();
		con.close();
		
	}

}
