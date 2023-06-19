package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseZhuboPortrait {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.courseZhuboPortrait("10001", "C:\\Users\\zhang\\Desktop\\aaa.png");
		System.out.println(res);
	}
}
