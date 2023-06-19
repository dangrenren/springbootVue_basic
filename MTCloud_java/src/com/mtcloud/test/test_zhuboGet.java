package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String account = "10000";
		int accountType = 2;
		
		String res = client.zhuboGet(account, accountType);
		System.out.println(res);
	}

}
