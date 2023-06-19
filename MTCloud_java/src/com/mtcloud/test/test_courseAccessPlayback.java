package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseAccessPlayback {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();      
		
		HashMap<Object,Object> options = new HashMap<Object, Object>();
		
		String res = client.courseAccessPlayback("29024", "10000", "test", MTCloud.ROLE_USER, 10000, options);
		System.out.println(res);
	}
}
