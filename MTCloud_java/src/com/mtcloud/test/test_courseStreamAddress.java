package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseStreamAddress {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("only-video", 1);
		
		String res = client.courseStreamAddress(17863, options);
		System.out.println(res);
	}

}
