package com.userservice;

import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.userservice.dao.AppUserDAO;
import com.userservice.model.AppUser;
import com.userservice.utlity.PasswordHash;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
/*
@Component
class cosmosdb
{
	cosmosdb(AppUserDAO mr) throws NoSuchAlgorithmException
	{
		mr.save(new AppUser("OD001","Abhishek Maity","a.maity@outlook.com","+919439876565",(new PasswordHash()).hash("abhimaity123")));
		mr.findAll().forEach(System.out::println);
	}
}
*/
