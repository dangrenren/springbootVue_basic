package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_getManagerUrl {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "119";
		int expire = 10000;
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res = client.getManagerUrl(roomid, expire, options);
		System.out.println(res);
		
		options.put("gender", MTCloud.USER_GENDER_MALE);
        options.put("avatar", "");
        String res2 = client.getManagerUrl(roomid, expire, options);
		System.out.println(res2);
	}

}
