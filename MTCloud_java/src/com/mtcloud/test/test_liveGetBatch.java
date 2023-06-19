package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveGetBatch {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String[] liveids = {"6", "7", "8"};
		
		String res = client.liveGetBatch(liveids, 10000);
		System.out.println(res);
	}

}
