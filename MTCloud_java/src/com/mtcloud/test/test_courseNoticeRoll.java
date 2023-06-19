package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseNoticeRoll {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseNoticeRoll(12654, "javasdk2", "http://www.talk-fun.com/", 3600);
		System.out.println(res);
	}

}
