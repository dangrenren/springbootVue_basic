package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_documentDownload {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String res = client.documentDownload(10);
		System.out.println(res);
	}

}
