package com.casestudy.admin.signup.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.admin.signup.model.admin;


public interface adminRepository  extends MongoRepository<admin,Integer>{
	
	List<admin> findByEmailId(String emailId);
}
