package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseOnlineList {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.courseOnlineList("21881", "2017-01-01 00:00:00", "2017-12-12 00:00:00", 1, 10);
		System.out.println(res);
	}
}
