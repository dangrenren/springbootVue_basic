package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_livePlaybackVisitorTimeList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.livePlaybackVisitorTimeList("2015-01-01 12:00:00", "2017-01-01 12:00:00", 1, 10);
		System.out.println(res);
	}

}
