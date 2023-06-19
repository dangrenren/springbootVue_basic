package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboUpdatePortrait {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String account = "10000";
		int accountType = 2;
		String filename = "C:\\Users\\k\\Desktop\\aaa.jpg";
		
		String res = client.zhuboUpdatePortrait(account, accountType, filename);
		System.out.println(res);
	}

}
