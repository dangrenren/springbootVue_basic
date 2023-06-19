package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_liveVoteAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		ArrayList op = new ArrayList();
		op.add("aaa");
		op.add("bbb");
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		options.put("status", 3);
		
		String res = client.liveVoteAdd("551759", "asd119", "test", "test", "test", op, 0, 1, "0", "H:\\tmp\\vim.jpg", options);
		System.out.println(res);
	}

}
