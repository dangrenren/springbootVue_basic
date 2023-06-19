package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_roomBroadcastSend {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "119";
		String cmd = "test";
		
		HashMap<Object,Object> _args = new HashMap<Object,Object>();
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res = client.roomBroadcastSend(roomid, cmd, _args,options);
		System.out.println(res);
	}

}
