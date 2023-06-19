package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_roomOnlineTotal {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		String res = client.roomOnlineTotal("673342");
		System.out.println(res);
	}

}
