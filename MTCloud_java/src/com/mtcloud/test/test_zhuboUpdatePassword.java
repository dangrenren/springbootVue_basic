package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboUpdatePassword {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String account = "10000";
		int accountType = 2;
		String password = "sdfdfsdfsdfs";
		
		String res = client.zhuboUpdatePassword(account, accountType, password);
		System.out.println(res);
	}

}
