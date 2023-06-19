package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseLaunch {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.courseLaunch(30054);
		System.out.println(res);
	}
}
