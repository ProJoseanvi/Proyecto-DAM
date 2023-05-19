package com.doctorplus.controller;

public class ResponseAction {

	private String success;
	private String message;
	
	
	public ResponseAction(String success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
