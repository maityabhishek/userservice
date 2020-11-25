package com.userservice.model;

public class AppUserAuthRes {
	
	private String token;
	private boolean status;
	private String message;
	
	public AppUserAuthRes(String token, boolean status, String message) {
		super();
		this.token = token;
		this.status = status;
		this.message = message;
	}
	
	public AppUserAuthRes() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
