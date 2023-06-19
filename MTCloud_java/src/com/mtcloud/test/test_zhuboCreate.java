package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboCreate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String account = "100001";
		String nickname = "aasdfdd";
		int accountType = 2;
		String password = "123456";
		String introduce ="ggggggggggggggggggggg";
		int departmentID = 0;
		
		String res = client.zhuboCreate(account, nickname, accountType, password, introduce, departmentID);
		System.out.println(res);

	}

}
