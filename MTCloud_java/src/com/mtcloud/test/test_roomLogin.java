package com.mtcloud.test;

import java.util.HashMap;
import com.mtcloud.sdk.MTCloud;

public class test_roomLogin {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "689125";

		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		options.put("ssl", true);
		
		String res = client.roomLogin(roomid, options);
		System.out.println(res);
	}

}
