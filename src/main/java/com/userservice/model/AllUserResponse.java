package com.userservice.model;

import java.util.List;

public class AllUserResponse {

	private List<AppUser> list;
	private String message;
	private int rescode;
	public List<AppUser> getList() {
		return list;
	}
	public void setList(List<AppUser> list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getRescode() {
		return rescode;
	}
	public void setRescode(int rescode) {
		this.rescode = rescode;
	}
	public AllUserResponse(List<AppUser> list, String message, int rescode) {
		super();
		this.list = list;
		this.message = message;
		this.rescode = rescode;
	}
	public AllUserResponse() {
		super();
	}
	
}
