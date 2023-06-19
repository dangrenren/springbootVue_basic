package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_departmentDelete {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.departmentDelete(78);
		System.out.println(res);
	}

}
