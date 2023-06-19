package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_liveVoteList {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.liveVoteList("8", 1, 10);
		System.out.println(res);
	}

}
