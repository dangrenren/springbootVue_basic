package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseChatDisableList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseChatDisableList(923155);
		System.out.println(res);
	}

}