package com.casestudy.admin.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.admin.orders.models.OrderDetails;
import com.casestudy.admin.orders.models.carwashers;

public interface orderrepository  extends  MongoRepository<OrderDetails,String>{
 List<OrderDetails> findByWasher(carwashers washer);
}

