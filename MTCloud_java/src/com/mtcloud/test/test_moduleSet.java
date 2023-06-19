package com.mtcloud.test;

import java.util.HashMap;

import com.mtcloud.sdk.MTCloud;

public class test_moduleSet {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		HashMap<Object,Object> options = new HashMap<Object,Object>();
		
		options.put("departmentID", 1);
//		options.put("livePcLogo", "H:\\tmp\\vim.png");
//		options.put("livePcLogoUrl", "http://open-1.talk-fun.com");
//		options.put("playbackPcLogo", "H:\\tmp\\vim.png");
//		options.put("playbackPcLogoUrl", "http://api.talk-fun.com");
		options.put("clientLogo", "H:\\tmp\\vim.png");
		
		String res = client.moduleSet(options);
		System.out.println(res);
	}
}
