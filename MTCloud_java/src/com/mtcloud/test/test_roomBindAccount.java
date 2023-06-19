package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_roomBindAccount {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "10299";
		
		String res = client.roomBindAccount(roomid, "10000", 2);
		System.out.println(res);
	}

}
