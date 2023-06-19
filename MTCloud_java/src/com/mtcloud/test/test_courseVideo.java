package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseVideo {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseVideo("39880");
		System.out.println(res);
	}

}
