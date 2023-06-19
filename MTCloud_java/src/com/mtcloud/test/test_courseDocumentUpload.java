package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_courseDocumentUpload {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		HashMap<String,String> file = new HashMap<String,String>();
		 
		file.put("file", "C:\\Users\\zhang\\Desktop\\ppt9.ppt");
		file.put("name", "documentName");
		 
		String res = client.courseDocumentUpload("29551", file);
		
		System.out.println(res);
	}
}
