package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_documentGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String res = client.documentGet(10002);
		System.out.println(res);
	}

}
