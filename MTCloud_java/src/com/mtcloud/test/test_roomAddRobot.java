package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_roomAddRobot {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		ArrayList userList = new ArrayList();
		HashMap<Object,Object> params = new HashMap<Object,Object>();
	    params.put("nickname", "wesin_");
		params.put("avatar", "");
		userList.add(params);
		String res = client.roomAddRobot(10162, userList);
		System.out.println(res);
	}

}
