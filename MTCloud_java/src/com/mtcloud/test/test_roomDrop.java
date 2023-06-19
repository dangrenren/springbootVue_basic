package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_roomDrop {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "10300";
		
		String res = client.roomDrop(roomid);
		System.out.println(res);
	}

}
