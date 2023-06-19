package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("departmentId", 6);
		options.put("barrage", 1);
		options.put("isPublic", 1);
		options.put("robotNumber", 1);
		options.put("robotType", 1);
		options.put("pptDisplay", 1);
		
		String res = client.courseAdd("java", "18122308579", "2015-01-01 12:00:00", "2017-01-01 12:00:00", "111", "222", options);
		System.out.println(res);
	}

}
