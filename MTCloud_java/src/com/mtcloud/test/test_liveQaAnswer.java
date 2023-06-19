package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_liveQaAnswer {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
				
		String res = client.liveQaAnswer(1459841, "652264", "java answer", "u10002", "nick2", options);
		System.out.println(res);
	}

}
