package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseUpdate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseUpdate("10008", "10000", "test", "2017-03-01 12:00:00", "2017-03-01 12:00:01", "nickname", "accountIntro");
		System.out.println(res);
	}

}
