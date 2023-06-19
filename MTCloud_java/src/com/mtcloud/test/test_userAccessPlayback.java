package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_userAccessPlayback {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String uid = "12345";
        String nickname = "大兵";
        String liveid = "1";
        int expire = 3600;
		
		String res = client.userAccessPlayback(uid, nickname, MTCloud.ROLE_USER, liveid, expire);
		System.out.println(res);
		
		HashMap<Object,Object> options = new HashMap<Object, Object>();
		String res2 = client.userAccessPlayback(uid, nickname, MTCloud.ROLE_USER, liveid, expire, options);
		System.out.println(res2);
		
		options.put("gender", MTCloud.USER_GENDER_MALE);
        options.put("avatar", "");
        String res3 = client.userAccessPlayback(uid, nickname, MTCloud.ROLE_USER, liveid, expire, options);
		System.out.println(res3);
	}

}
