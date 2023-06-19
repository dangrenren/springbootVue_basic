package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveAlbumGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveAlbumGet("10000", 10000);
		System.out.println(res);
	}

}
