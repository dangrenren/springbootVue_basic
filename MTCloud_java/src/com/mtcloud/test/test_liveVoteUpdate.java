package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_liveVoteUpdate {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		ArrayList op = new ArrayList();
		op.add("aaa");
		op.add("bbb");
		
		options.put("op", op);
		options.put("image", "H:\\tmp\\vim.png");
		
		String res = client.liveVoteUpdate("17340", options);
		System.out.println(res);
	}

}
