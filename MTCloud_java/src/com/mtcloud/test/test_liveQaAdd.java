package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_liveQaAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
				
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res = client.liveQaAdd("652264", "java test6", "u10000", "user", "nick", options);
		System.out.println(res);
	}

}
