package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_livePlaybackLoginUrl {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.livePlaybackLoginUrl(123);
		System.out.println(res);
	}

}
