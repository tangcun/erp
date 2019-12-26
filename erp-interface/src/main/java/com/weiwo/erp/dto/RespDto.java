package com.weiwo.erp.dto;

import com.weiwo.erp.util.ResultUtil;

import java.io.Serializable;

public class RespDto extends ResultUtil implements Serializable {
	private static final long serialVersionUID = 1L;
	int status; //状态 0:失败，1：成功 2:需要重新登录
	String message; // 响应状态内容
	Object responseData; // 响应数据对象

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	public RespDto(ResultUtil resultUtil) {
		this.status=1;
		super.setData(resultUtil.getData());
		super.setITotalRecords(resultUtil.getITotalRecords());
		super.setITotalDisplayRecords(resultUtil.getITotalRecords());
	}

//	public RespDto(Object object) {
//		this.status=1;
//		this.responseData=object;
//	}

	public RespDto() {
		this.status=1;
	}
}
