package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseVoteList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseVoteList("11783", 1, 10,"all");
		System.out.println(res);
	}

}
