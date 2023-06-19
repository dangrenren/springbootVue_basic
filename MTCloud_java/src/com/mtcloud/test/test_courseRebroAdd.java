package com.mtcloud.test;


import com.mtcloud.sdk.MTCloud;

public class test_courseRebroAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       		
		String res = client.courseRebroAdd("1","2");
		System.out.println(res);
	}

}
