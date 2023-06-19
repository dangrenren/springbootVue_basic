package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveGet("1", 1);
		System.out.println(res);
	}

}
