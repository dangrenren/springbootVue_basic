package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveAlbumDelete {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveAlbumDelete("10000");
		System.out.println(res);
	}

}
