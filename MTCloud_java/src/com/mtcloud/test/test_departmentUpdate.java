package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_departmentUpdate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.departmentUpdate(78, "javaU");
		System.out.println(res);
	}

}
