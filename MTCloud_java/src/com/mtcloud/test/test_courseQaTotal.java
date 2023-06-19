package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseQaTotal {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();     
		
		String res = client.courseQaTotal(66920);
		System.out.println(res);
	}

}
