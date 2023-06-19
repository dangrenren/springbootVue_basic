package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_departmentMaxUserGet {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String res = client.departmentMaxUserGet(1);
		System.out.println(res);
	}
}
