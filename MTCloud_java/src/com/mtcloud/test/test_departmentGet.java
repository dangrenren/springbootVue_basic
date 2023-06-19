package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_departmentGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.departmentGet(75);
		System.out.println(res);
	}

}
