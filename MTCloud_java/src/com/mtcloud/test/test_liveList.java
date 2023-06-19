package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String startDate = "2015-01-01";
		String endDate = "2017-01-01";
		
		String res = client.liveList(startDate, endDate, 1, 10, 1);
		System.out.println(res);
	}

}
