package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveMaxUserGet {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String res = client.liveMaxUserGet();
		System.out.println(res);
	}
}
