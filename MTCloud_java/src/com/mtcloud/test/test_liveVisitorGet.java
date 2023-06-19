package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveVisitorGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveVisitorGet("8", "10000");
		System.out.println(res);
	}

}
