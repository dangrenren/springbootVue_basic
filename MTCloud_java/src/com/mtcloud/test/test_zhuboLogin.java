package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboLogin {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("ssl", true);
		
		String res = client.zhuboLogin("10000", MTCloud.ACCOUNT_TYPE_MT, options);
		System.out.println(res);
	}

}
