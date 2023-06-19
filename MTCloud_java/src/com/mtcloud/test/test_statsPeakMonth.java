package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_statsPeakMonth {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.statsPeakMonth("2017-04", 2);
		System.out.println(res);
	}
}
