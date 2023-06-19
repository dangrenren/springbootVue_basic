package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_consoleAutoLogin {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud("","");
		
		String res = client.consoleAutoLogin(111, 3600, "course-231");
		System.out.println(res);
	}

}
