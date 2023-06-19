package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseQaAnswer {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();     
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res = client.courseQaAnswer(944091, 66840, "java answer", "u10001", "nick2", options);
		System.out.println(res);
	}

}
