package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_generateShortUrl {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();  
		
		String res = client.generateShortUrl("http://www.talk-fun.com/");
		System.out.println(res);
	}

}
