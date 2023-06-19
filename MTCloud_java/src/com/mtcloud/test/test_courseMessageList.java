package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseMessageList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseMessageList("10002", 1, 20);
		System.out.println(res);
	}

}
