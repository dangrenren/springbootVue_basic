package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_clipDelete {

	public static void main(String[] args) throws Exception {
		 MTCloud client = new MTCloud();    
		 
		 String res = client.clipDelete(10);
		 System.out.println(res);
	}

}
