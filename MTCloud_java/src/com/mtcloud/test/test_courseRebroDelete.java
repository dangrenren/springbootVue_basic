package com.mtcloud.test;


import com.mtcloud.sdk.MTCloud;

public class test_courseRebroDelete {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       		
		String res = client.courseRebroDelete("1","2");
		System.out.println(res);
	}

}
