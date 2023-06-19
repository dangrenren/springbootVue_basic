package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_AlbumAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String[] liveids = {"7", "8", "9"};
		
		String res = client.albumAdd("10000", liveids);
		System.out.println(res);
	}

}
