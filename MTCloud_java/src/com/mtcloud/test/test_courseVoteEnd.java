package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseVoteEnd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseVoteEnd(1431, 1, "asd10008","test");
		System.out.println(res);
	}

}
