package com.mtcloud.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;

import com.mtcloud.sdk.MTCloud;

public class test_courseVoteAdd {

	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud();    
		
		ArrayList op = new ArrayList();
		op.add("aaa");
		op.add("bbb");
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		options.put("status", 3);
		
		String res = client.courseVoteAdd("13392", "asd10008", "java", "java", "java", op, 0, 1, "0", "H:\\tmp\\vim.jpg", options);
		System.out.println(res);
	}

}
