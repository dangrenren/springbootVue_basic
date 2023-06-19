package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_AlbumCreateCourse {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String[] course_ids = {"10002", "10003", "10004"};
		
		String res = client.albumCreateCourse("test", course_ids);
		System.out.println(res);
	}

}
