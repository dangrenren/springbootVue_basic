package com.mtcloud.test;

import java.util.HashMap;
import com.mtcloud.sdk.MTCloud;

public class test_roomCreate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomName = "请问请问请问";
		
		String res = client.roomCreate(roomName);
		System.out.println(res);
		
		String authKey = "123456";
		
		String res2 = client.roomCreate(roomName, authKey);
		System.out.println(res2);
		
		int voiceFlow = 2;
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res3 = client.roomCreate(roomName, voiceFlow, authKey,3,options);
		System.out.println(res3);
	}

}
