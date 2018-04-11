package com.genvict.message.framework.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseHeader {
	
	@JsonProperty("biz_code")
    private int bizCode;
	
	@JsonProperty("biz_result")
    private String bizResult;
	
	public ResponseHeader() {
		setBizCode(0);
		setBizResult("SUCCESS");
	}
	
	public ResponseHeader(int bizCode, String bizResult) {
		setBizCode(bizCode);
		setBizResult(bizResult);
	}
	
    public int getBizCode() {
        return this.bizCode;
    }

    public void setBizCode(int bizCode) {
        this.bizCode = bizCode;
    }
    
    public String getBizResult() {
        return this.bizResult;
    }

    public void setBizResult(String bizResult) {
        this.bizResult = bizResult;
    }
    
}
