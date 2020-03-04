package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;



public class MetaData {
	String dbUsername="syntax_hrm";
	
	String dbPassword="syntaxhrm123";
	
	String dbURL="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	@Test
	public void getMetaData() throws SQLException {
		
		Connection c=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		
		DatabaseMetaData dbData=c.getMetaData();
		
		String dbName=dbData.getDatabaseProductName();
		String dbVersion=dbData.getDatabaseProductVersion();
		
		System.out.println(dbName);
		System.out.println(dbVersion);
		Statement s=c.createStatement();
        ResultSet rset=s.executeQuery("select * from hs_hr_employees where emp_number=4353");
        
        ResultSetMetaData resultData = rset.getMetaData();
        int cols=resultData.getColumnCount();
        
        System.out.println(cols);
        
        String colname=resultData.getColumnName(1);
        System.out.println(colname);
        
        for(int i=1; i<=cols; i++) {
            String colName=resultData.getColumnName(i);
            System.out.println(colName);
        }
      
        rset.close();
		s.close();
		c.close();
    }
}




