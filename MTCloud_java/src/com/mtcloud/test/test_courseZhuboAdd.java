package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseZhuboAdd {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.courseZhuboAdd("asssww", "test", "aaaa", "bbb");
		System.out.println(res);
	}
}
