package com.mtcloud.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseRobotSet {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();
		
		ArrayList userList = new ArrayList();
		HashMap user = new HashMap<Object,Object>();
		HashMap user2 = new HashMap<Object,Object>();
		
		user.put("nickname", "王雨--河北农业大学");
		user.put("avatar", "");
		userList.add(user);
		
		user2.put("nickname", "王宇--河北农业大学");
		user2.put("avatar", "");
		userList.add(user2);
		
		String res = client.courseRobotSet(11461, userList);
		System.out.println(res);
	}

}
