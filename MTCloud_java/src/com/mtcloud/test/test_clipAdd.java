package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_clipAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		HashMap<Object,Object> time = new HashMap<Object,Object>();
		HashMap<Object,Object> t = new HashMap<Object,Object>();
		
		t.put("start", 1);
		t.put("end", 1000);
		
		time.put("0", t);
		
		String res = client.clipAdd(8, "test", time, 0);
		System.out.println(res);
	}

}
