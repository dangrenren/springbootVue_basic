package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_documentList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String res = client.documentList(119);
		System.out.println(res);
	}

}
