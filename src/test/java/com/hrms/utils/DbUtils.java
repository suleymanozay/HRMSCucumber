package com.hrms.utils;

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

public class DbUtils {
	
	private static Connection conn;
	private static Statement st;
	private static ResultSet rSet;
	private static List<Map<String, String>> listData;

	/**
	 * Method will create a connection to DB
	 */
	public static void createConnection() {
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		 try {
			conn=DriverManager.getConnection(ConfigsReader.getProperty("dbURL"), 
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
					e.printStackTrace();
		}
				
	}
	
	/**
	 * Retrives data and stored inside List<Map>
	 * @return List<Map<String,String>>
	 */
	public static List<Map<String, String>> storeDataFromDB(String  sqlQuery){
		try {
			st=conn.createStatement();
			rSet=st.executeQuery(sqlQuery);
			ResultSetMetaData rSetMetaData=rSet.getMetaData();
			listData=new ArrayList<>();
			
			
			while(rSet.next()) {
				Map<String, String> rowMap=new LinkedHashMap<>();
				
				for (int i = 1; i <=rSetMetaData.getColumnCount(); i++) {
					rowMap.put(rSetMetaData.getColumnName(i), rSet.getObject(i).toString());
				}
				listData.add(rowMap);
			}
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return listData;
	}
	
	public static void closeResources() {
		try {
		
			if(rSet!=null) {
				rSet.close();
			}
			if(st!=null) {
				st.close();
			}
			if(conn!=null) {
				conn.close();
			}
				
		} catch (SQLException e) {
			
		}
		
		
		
	}
}
