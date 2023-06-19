package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_departmentGetBatch {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String[] departmentIds = {"75", "74", "73", "54"};
		
		String res = client.departmentGetBatch(departmentIds);
		System.out.println(res);
	}

}
