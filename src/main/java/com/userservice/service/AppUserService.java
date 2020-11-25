package com.userservice.service;

import org.springframework.stereotype.Service;

import com.userservice.model.AllUserResponse;
import com.userservice.model.AppUser;
import com.userservice.model.AppUserAuthRes;
import com.userservice.model.UserLogin;

@Service
public interface AppUserService {

	public int addUser(AppUser user);
	public AllUserResponse getAllUser();
	public AppUserAuthRes authUser(UserLogin user);
	
	
}
