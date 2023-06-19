package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_updateLifeConfig {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud("","");
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("pageViewMode",1);
		
		String res = client.updateLifeConfig(123456,options);
		System.out.println(res);
	}

}
