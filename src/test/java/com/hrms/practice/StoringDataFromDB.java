package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringDataFromDB {
	String dbUsername="syntax_hrm";
	
	String dbPassword="syntaxhrm123";
	
	String dbURL="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	@Test
	public void getAndStoreData() throws SQLException {
		Connection con=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st=con.createStatement();
		ResultSet rSet=st.executeQuery("select id, name, country_code from ohrm_location;");
		//ResultSet rSet=st.executeQuery("select * from ohrm_location;");
		
		List<Map<String, String>> listData=new ArrayList<>();
		
		while(rSet.next()) {
			Map<String, String> map=new LinkedHashMap<>();
			map.put("id", rSet.getObject("id").toString());
			map.put("name", rSet.getObject("name").toString());
			map.put("country_code", rSet.getObject("country_code").toString());
			
			listData.add(map);
			
		}
		
		System.out.println(listData);
	
			
		}
	
	@Test
	public void getAndStoreDataEnhanced() throws SQLException {
		Connection con=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st=con.createStatement();
		ResultSet rSet=st.executeQuery("select id, name, country_code from ohrm_location;");
		ResultSetMetaData rSetMetaData=rSet.getMetaData();
		List<Map<String, String>> listData=new ArrayList<>();
		Map<String, String> rowMap;
		
		while(rSet.next()) {
			rowMap=new LinkedHashMap<>();
			for (int i = 1; i <=rSetMetaData.getColumnCount(); i++) {
				rowMap.put(rSetMetaData.getColumnName(i), rSet.getObject(i).toString());
				listData.add(rowMap);
				
			}
			
		}
		System.out.println(listData);
		rSet.close();
		st.close();
		con.close();
		
	}
	

		}


