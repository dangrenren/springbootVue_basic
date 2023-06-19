package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_AlbumDelete {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.albumDelete("10000");
		System.out.println(res);
	}

}
