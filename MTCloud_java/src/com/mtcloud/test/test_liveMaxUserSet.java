package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_liveMaxUserSet {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("liveMaxUser", 10000);
		options.put("vodMaxUser", 20000);
		
		String res = client.liveMaxUserSet(options);
		System.out.println(res);
	}
}
