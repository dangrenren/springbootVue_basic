package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseLogin {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();      
		
		HashMap<Object,Object> options = new HashMap<Object, Object>();
		options.put("ssl", false);
		
		String res = client.courseLogin("10000", MTCloud.ACCOUNT_TYPE_MT, options);
		System.out.println(res);
	}
}
