package com.genvict.message.framework.service;

import com.genvict.message.framework.utility.ResponseHeader;

public class WsResponse extends ResponseHeader {

	public WsResponse(int bizCode, String bizResult) {
		setBizCode(bizCode);
		setBizResult(bizResult);
	}

	public WsResponse() {
		setBizCode(0);
		setBizResult("SUCCESS");
	}

}
