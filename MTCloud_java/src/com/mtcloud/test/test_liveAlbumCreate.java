package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveAlbumCreate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String[] liveids = {"8", "9", "7"};
		
		String res = client.liveAlbumCreate("teadsdst", liveids);
		System.out.println(res);
	}

}
