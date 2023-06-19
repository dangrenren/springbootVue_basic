package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_clipAccess {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.clipAccess(74082, "11111", "test", 86400);
		System.out.println(res);
	}
}
