package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_AlbumRemoveCourse {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String[] course_ids = {"10002", "10003", "10004"};
		
		String res = client.albumRemoveCourse("1", course_ids);
		System.out.println(res);
	}

}
