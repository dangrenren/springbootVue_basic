package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_userAccessPlaybackUrl {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		HashMap<Object,Object> options = new HashMap<Object, Object>();
		
		options.put("avatar", "");
		
		String res = client.userAccessPlaybackUrl("10000", "test", "user", "1372778", 3600, options);
		System.out.println(res);
	}

}
