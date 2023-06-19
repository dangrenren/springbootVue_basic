package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_generateSign {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		HashMap<Object,Object> params = new HashMap<Object,Object>();
		
		params.put("ddg", "test");
		
		String res = client.generateSign(params);
		System.out.println(res);
	}

}
