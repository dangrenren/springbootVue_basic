package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseVoteEmit {
	
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		String res = client.courseVoteEmit(16403, 13392);
		System.out.println(res);
	}
}
