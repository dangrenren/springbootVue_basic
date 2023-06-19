package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_liveQaDelete {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();       
				
		String res = client.liveQaDelete(1459835, "652264");
		System.out.println(res);
	}

}
