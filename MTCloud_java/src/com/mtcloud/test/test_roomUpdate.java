package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_roomUpdate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "10297";
		
		HashMap<Object,Object> params = new HashMap<Object,Object>();
		
		params.put("roomName", "modify");
		
		String res = client.roomUpdate(roomid, params);
		System.out.println(res);
	}

}
