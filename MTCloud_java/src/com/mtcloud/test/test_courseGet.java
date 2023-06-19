package com.mtcloud.test;

import java.util.HashMap;
import com.mtcloud.sdk.MTCloud;

public class test_courseGet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		HashMap<Object,Object> options = new HashMap<Object, Object>();
		String res = client.courseGet("8",options);
		System.out.println(res);
	}

}
