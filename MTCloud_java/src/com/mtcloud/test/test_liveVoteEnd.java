package com.mtcloud.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;

import com.mtcloud.sdk.MTCloud;

public class test_liveVoteEnd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();    
		
		String res = client.liveVoteEnd("16205", 1, "asd119", "test");
		System.out.println(res);
	}

}
