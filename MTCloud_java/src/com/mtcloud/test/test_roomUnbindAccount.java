package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_roomUnbindAccount {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "10299";
		String account = "10000";
		int accountType = 2;
		
		String res = client.roomUnbindAccount(roomid, account, accountType);
		System.out.println(res);
	}

}
