package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;
import java.util.HashMap;


public class test_departmentUpdateCallbackApiBatch {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<String,String> callbackApis = new HashMap<String,String>();
		callbackApis.put("1", "http://www.talk-fun.com/");
		callbackApis.put("2", "https://www.talk-fun.com/");

		String res = client.departmentUpdateCallbackApiBatch(callbackApis);
		System.out.println(res);
	}

}
