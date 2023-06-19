package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_userAccessPlaybackAlbumUrl {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String uid = "12345";
        String nickname = "大兵";
        String album_id = "100985";
        int expire = 3600;
		
        HashMap<Object,Object> options = new HashMap<Object, Object>();
        
		String res = client.userAccessPlaybackAlbumUrl(uid, nickname, MTCloud.ROLE_USER, album_id, expire, options);
		System.out.println(res);
	}

}
