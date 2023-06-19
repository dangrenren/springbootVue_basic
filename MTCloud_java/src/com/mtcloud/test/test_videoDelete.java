package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_videoDelete {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.videoDelete(4);
		System.out.println(res);
	}
}
