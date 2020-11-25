package com.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AppUser {
	@Id
	private String drivingid;
	private String name;
	private String email;
	private String phoneno;
	private String password;
	public String getDrivingid() {
		return drivingid;
	}
	public void setDrivingid(String drivingid) {
		this.drivingid = drivingid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AppUser(String drivingid, String name, String email, String phoneno, String password) {
		super();
		this.drivingid = drivingid;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
	}
	public AppUser() {
		super();
	}
	
	

}
