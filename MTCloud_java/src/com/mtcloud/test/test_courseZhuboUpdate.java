package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseZhuboUpdate {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.courseZhuboUpdate("10000", "ccc", "", "");
		System.out.println(res);
	}
}
