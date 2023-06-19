package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_roomNoticeRoll {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		String res = client.roomNoticeRoll("551759", "javasdk", "http://www.talk-fun.com", 3600);
		System.out.println(res);
	}

}
