package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_courseUploadPlayback {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		String res = client.courseUploadPlayback(13391, "1.flv");
		System.out.println(res);
	}
}
