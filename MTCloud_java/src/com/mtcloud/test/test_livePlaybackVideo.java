package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_livePlaybackVideo {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.livePlaybackVideo(1261055);
		System.out.println(res);
	}

}
