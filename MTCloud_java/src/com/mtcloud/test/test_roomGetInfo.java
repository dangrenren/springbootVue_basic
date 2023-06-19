package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_roomGetInfo {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "119";
		
		String res = client.roomGetInfo(roomid);
		System.out.println(res);
	}

}
