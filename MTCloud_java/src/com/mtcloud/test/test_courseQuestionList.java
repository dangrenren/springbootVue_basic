package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseQuestionList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseQuestionList("10002", 1, 10);
		System.out.println(res);
	}

}
