package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_zhuboUpdateInfo {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String account = "10000";
		int accountType = 2;
		String nickname = "modify";
		String introduce = "sssss";
		int departmentID = 0;
		
		String res = client.zhuboUpdateInfo(account, accountType, nickname, introduce,departmentID);
		System.out.println(res);
	}

}
