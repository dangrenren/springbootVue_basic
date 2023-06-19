package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveListAll {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveListAll(1, 10, "DESC", "0");
		System.out.println(res);
	}

}
