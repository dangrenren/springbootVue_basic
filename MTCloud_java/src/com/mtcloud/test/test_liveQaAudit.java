package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_liveQaAudit {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
				
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		String res = client.liveQaAudit(1459835, "652264");
		System.out.println(res);
	}

}
