package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_clipList {

	public static void main(String[] args) throws Exception {
		 MTCloud client = new MTCloud();    
		 
		 String res = client.clipList(1, 10);
		 System.out.println(res);
		 
		 String res2 = client.clipList(1, 10, 1389255);
		 System.out.println(res2);
	}

}
