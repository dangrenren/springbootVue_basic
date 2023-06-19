package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseQaAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res = client.courseQaAdd(66840, "java test2", "u10000", MTCloud.ROLE_USER, "nick", options);
		System.out.println(res);
	}

}
