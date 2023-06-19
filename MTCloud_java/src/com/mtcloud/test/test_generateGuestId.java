package com.mtcloud.test;

import java.util.UUID;

import com.mtcloud.sdk.MTCloud;

public class test_generateGuestId {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();  
		
		UUID res = client.generateGuestId();
		System.out.println(res);
	}

}
