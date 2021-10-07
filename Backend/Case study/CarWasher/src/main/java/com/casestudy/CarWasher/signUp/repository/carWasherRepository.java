package com.casestudy.CarWasher.signUp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.CarWasher.signUp.models.carwashers;



public interface carWasherRepository  extends MongoRepository<carwashers,Integer>{
	
	List<carwashers> findByEmailId(String emailId);
}
