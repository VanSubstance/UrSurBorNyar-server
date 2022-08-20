package com.my.ursurbornyar.vo;

public class Response {
	private Object data;
	private int status;
	private String message;

	public Response() {
		data = null;
		status = 0;
		message = "";
	}

	public Response(boolean isSuccess) {
		if (!isSuccess) {
			data = null;
			status = 0;
			message = "";
		} else {
			data = null;
			status = 1;
			message = "Failed";
		}
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

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
}
