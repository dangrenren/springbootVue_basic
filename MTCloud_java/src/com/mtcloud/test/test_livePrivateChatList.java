package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_livePrivateChatList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.livePrivateChatList("1000007263", 1, 10);
		System.out.println(res);
	}

}
