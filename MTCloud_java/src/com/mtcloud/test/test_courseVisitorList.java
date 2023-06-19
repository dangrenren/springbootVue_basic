package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseVisitorList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("start_time", "2016-11-26 18:00:00");
		options.put("end_time", "2016-11-27 00:00:00");
		
		String res = client.courseVisitorList("13091", 1, 10, options);
		System.out.println(res);
	}

}
