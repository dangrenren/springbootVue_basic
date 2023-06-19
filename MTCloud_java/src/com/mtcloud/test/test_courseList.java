package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("status", 0);
		
		String res = client.courseList("2015-01-01 12:00:00", "2017-01-01 12:00:00", 1, 10, options);
		System.out.println(res);
	}

}
