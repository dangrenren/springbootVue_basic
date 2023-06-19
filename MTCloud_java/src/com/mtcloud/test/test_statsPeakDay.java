package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_statsPeakDay {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.statsPeakDay("2017-05-23", 1);
		System.out.println(res);
	}
}
