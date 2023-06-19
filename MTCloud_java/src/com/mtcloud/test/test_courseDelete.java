package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseDelete {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseDelete("8");
		System.out.println(res);
	}

}
