package com.zillion.api.palicount.exceptions;

import org.json.simple.JSONArray;

public class ErrorMessage {

	private int status;
	private String message;

	public ErrorMessage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
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


	@Override
	public String toString() {
		JSONArray array = new JSONArray();
		array.add("status=" + status + ", message=" + message);
		return array.toString();
	}

}
