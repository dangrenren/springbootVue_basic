package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboRoomLogin {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("ssl", true);
		
		String res = client.zhuboRoomLogin("119", options);
		System.out.println(res);
	}

}
