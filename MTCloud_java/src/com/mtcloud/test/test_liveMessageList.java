package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveMessageList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveMessageList("8", 1);
		System.out.println(res);
	}

}
