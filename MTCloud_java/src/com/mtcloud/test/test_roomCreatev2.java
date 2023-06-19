package com.mtcloud.test;

import java.util.HashMap;
import com.mtcloud.sdk.MTCloud;

public class test_roomCreatev2 {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomName = "请问请问请问";
		
		String authKey = "123456";
		
		String userKey = "123333";
		
		String zhuboKey = "123111";
		
		int modetype = 3;

		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		options.put("barrage", 1);
		
		String res = client.roomCreatev2(roomName, authKey, userKey, zhuboKey, modetype, options);
		System.out.println(res);
	}

}
