package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveGetLast {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveGetLast(10, 119);
		System.out.println(res);
	}

}
