package com.mtcloud.test;

import com.mtcloud.sdk.MTCloud;

public class test_videoGetBatch {
	public static void main(String[] args) throws Exception {
		MTCloud client = new MTCloud(); 
		
		int[] videoIds = {665, 666};
		
		String res = client.videoGetBatch(videoIds, 86400);
		System.out.println(res);
	}
}
