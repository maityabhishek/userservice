package com.userservice.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.dao.AppUserDAO;
import com.userservice.model.AllUserResponse;
import com.userservice.model.AppUser;
import com.userservice.model.AppUserAuthRes;
import com.userservice.model.UserLogin;
import com.userservice.utlity.PasswordHash;

@Service
public class AppUserServiceImpl implements AppUserService{
	
	@Autowired
	private AppUserDAO appUserDAO;
	@Autowired
	private PasswordHash passwordHash;
	
	public int addUser(AppUser user)
	{
		try {
			user.setPassword(passwordHash.hash(user.getPassword()));
			appUserDAO.save(user);
			return 1;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public AllUserResponse getAllUser()
	{
		List<AppUser> list = appUserDAO.findAll();
		if(list.isEmpty())
		{
			return new AllUserResponse(null,"No Records To Return",0);
		}
		else
		{
			return new AllUserResponse(list,"Records Fetched Sucessfully",list.size());
		}
		
	}
	public AppUserAuthRes authUser(UserLogin user)
	{
		AppUser appUser= appUserDAO.findById(user.getUserId()).orElse(null);
		try
		{
			if(appUser==null)
			{
				return new AppUserAuthRes("",false,"Invalid UserId or Password");
			}
			else
			{
				if((appUser.getPassword()).equals(passwordHash.hash(user.getPassword())))
				{
					return new AppUserAuthRes(passwordHash.hash(user.getUserId()),true,"Auth Sucess");
				}
				else
				{
					return new AppUserAuthRes("",false,"Invalid UserId or Password");
				}
			}
		}
	
	catch (Exception e) {
		e.printStackTrace();
		return new AppUserAuthRes("",false,"Some Internal Error Has Occured Please Try later");
	}
		
		
	}
	

}
