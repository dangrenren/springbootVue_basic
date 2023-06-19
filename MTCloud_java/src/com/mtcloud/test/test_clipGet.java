package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_clipGet {

	public static void main(String[] args) throws Exception {
		 MTCloud client = new MTCloud();    
		 
		 String res = client.clipGet(300);
		 System.out.println(res);
	}

}
