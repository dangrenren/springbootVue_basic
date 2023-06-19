package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_coursePrivateChatList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.coursePrivateChatList(1000007263, 1, 10);
		System.out.println(res);
	}

}
