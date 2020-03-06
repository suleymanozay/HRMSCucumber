package com.hrms.practice;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.hrms.utils.DbUtils;

public class Task1 extends DbUtils {
	
	@Test
	public void Task() {
		createConnection();
		
		List<Map<String, String>> list=storeDataFromDB("select id, name, country_code from ohrm_location;");
		System.out.println(list);
	
		boolean bak=list.isEmpty();
		System.out.println(bak);
		for (Map<String, String> map : list) {
			Collection<String> collection=map.values();
			for (String map2 : collection) {
				System.out.println(map2);
				
			}
			
		}
	
		closeResources();
		
		
	}

}