package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_userOnlineList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "119";
		String start_time = "2015-01-01 12:00:00";
		String end_time = "2017-01-01 12:00:00";
		
		String res = client.userOnlineList(roomid, start_time, end_time);
		System.out.println(res);
	}

}
