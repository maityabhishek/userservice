package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.model.AllUserResponse;
import com.userservice.model.AppUser;
import com.userservice.model.UserLogin;
import com.userservice.service.AppUserService;


@RestController
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	@RequestMapping(method=RequestMethod.POST,path="/user-signup")
	public ResponseEntity<?> userSignup(@RequestBody AppUser user)
	{
		int res=appUserService.addUser(user);
		if(res==0)
		{
			return new ResponseEntity<>("Unable to Create your account",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<>("User Created Sucessfully",HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/userviewall")
	public ResponseEntity<?> userViewAll(@RequestHeader(name="Authorization")String token)
	{
		if(token.equals("maity-iot"))
		{
			return new ResponseEntity<>(appUserService.getAllUser(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(new AllUserResponse(null,"Invalid Credentials",0),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/auth-user")
	public ResponseEntity<?> authUser(@RequestBody UserLogin user)
	{
		return new ResponseEntity<>(appUserService.authUser(user),HttpStatus.OK);
	} 

}
