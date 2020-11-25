package com.userservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userservice.model.AppUser;

public interface AppUserDAO extends MongoRepository<AppUser, String> {

}
