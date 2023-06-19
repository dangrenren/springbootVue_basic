package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseUpdateConfig {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("barrage", 1);
		options.put("isPublic", 1);
		options.put("robotNumber", 1);
		options.put("robotType", 1);
		options.put("pptDisplay", 1);
		
		String res = client.courseUpdateConfig("10721", options);
		System.out.println(res);
	}

}
