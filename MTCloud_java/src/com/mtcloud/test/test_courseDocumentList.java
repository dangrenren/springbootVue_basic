package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseDocumentList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseDocumentList("10002", 1);
		System.out.println(res);
	}

}
