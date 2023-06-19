package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveAudioDownloadUrl {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveAudioDownloadUrl("8");
		System.out.println(res);
	}

}
