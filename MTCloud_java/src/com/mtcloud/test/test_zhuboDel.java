package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboDel {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String account = "10000";
		int accountType = 2;
		
		String res = client.zhuboDel(account, accountType);
		System.out.println(res);
	}

}
