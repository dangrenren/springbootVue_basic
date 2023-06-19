package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_AlbumCreate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String[] liveids = {"7", "8", "9"};
		
		String res = client.albumCreate("test", liveids);
		System.out.println(res);
	}

}
