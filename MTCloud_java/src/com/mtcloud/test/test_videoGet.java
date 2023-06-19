package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_videoGet {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.videoGet(666, 86400);
		System.out.println(res);
	}
}
