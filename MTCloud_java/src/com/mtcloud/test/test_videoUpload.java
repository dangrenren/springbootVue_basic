package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_videoUpload {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		HashMap<Object,Object> course = new HashMap<Object,Object>();
		
		String res = client.videoUpload("test.flv", "10000", MTCloud.ACCOUNT_TYPE_THIRD, "title", "nickname", "accountIntro",course);
		System.out.println(res);
	}
}
