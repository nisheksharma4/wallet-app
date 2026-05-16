package com.nsdev.walletapp.util;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseStructure<T> {

	private boolean success;
	private String message;
	private T data;

	public ResponseStructure() {
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}