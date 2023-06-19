package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseQaAudit {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
		
		String res = client.courseQaAudit(944090, 66840);
		System.out.println(res);
	}

}
