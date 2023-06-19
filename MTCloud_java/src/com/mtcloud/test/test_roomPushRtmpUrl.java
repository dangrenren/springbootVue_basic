package com.mtcloud.test;

import java.util.HashMap;
import com.mtcloud.sdk.MTCloud;

public class test_roomPushRtmpUrl {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String roomid = "689125";
		
		String title = "haha";
		
		int ratio = 2;
		
		String res = client.roomPushRtmpUrl(roomid, title, ratio);
		System.out.println(res);
	}

}
