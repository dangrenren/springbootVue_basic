package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_userAccess {
	public static void main(String[] args) throws Exception {
        MTCloud client = new MTCloud();       

        String uid = "12345";
        String nickname = "大兵";
        String roomid = "119";
        int expire = 3600;
        
        String res = client.userAccess(uid,nickname,MTCloud.ROLE_USER,roomid,expire);
        System.out.println(res);
        
        HashMap<Object,Object> options = new HashMap<Object, Object>();
        String res2 = client.userAccess(uid, nickname, MTCloud.ROLE_USER, roomid, expire, options);
        System.out.println(res2);
        
        options.put("gender", MTCloud.USER_GENDER_MALE);
        options.put("avatar", "");
        HashMap<Object,Object> options2 = new HashMap<Object, Object>();
        String res3 = client.userAccess(uid, nickname, MTCloud.ROLE_USER, roomid, expire, options);
        System.out.println(res3);
	}
}
