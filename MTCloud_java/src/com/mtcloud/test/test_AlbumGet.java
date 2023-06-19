package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_AlbumGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.albumGet("1", 10000);
		System.out.println(res);
	}

}
