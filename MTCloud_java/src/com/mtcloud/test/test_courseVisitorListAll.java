package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseVisitorListAll {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res = client.courseVisitorListAll("2016-11-26 18:00:00", "2016-11-27 00:00:00", 1, 10);
		System.out.println(res);
	}

}
