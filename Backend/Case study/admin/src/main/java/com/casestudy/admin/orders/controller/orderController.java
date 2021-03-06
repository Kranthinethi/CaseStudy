package com.casestudy.admin.orders.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.casestudy.admin.orders.models.OrderDetails;
import com.casestudy.admin.orders.models.carwashers;
import com.casestudy.admin.orders.repository.orderrepository;
import com.casestudy.admin.services.EmailSenderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class orderController {

	@Autowired
	LoadBalancerClient loadbalancer;
	
	@Autowired
	EmailSenderService service;
	
	RestTemplate resttemplate=new RestTemplate();
	
	@Autowired
	orderrepository repository;
	
	@PostMapping("/addorders")
	public String addOrder(@RequestBody OrderDetails order) throws DuplicateKeyException
	{
		try {
		repository.save(order);
		return "success with order Id"+order.getId();
	}catch(DuplicateKeyException e) {
		return "Duplicate Entry";
		}
	}
	
	@GetMapping("/findOrders")
	public List<OrderDetails> getorders(){
		return repository.findAll();
	}
	@GetMapping("/findwasher/{washerid}")
	public List<OrderDetails> getwasherorders(@PathVariable String washerid){
	
			carwashers c=resttemplate.getForObject(getBaseUrl()+"/washer/findAll/"+washerid,carwashers.class);
			return repository.findByWasher(c);
	}
	private String getBaseUrl() {
		ServiceInstance s=loadbalancer.choose("CARWASHERMICROSERVICE");
		return s.getUri().toString();
	}
	
	@RequestMapping(value="/sendEmail/{mail}",method = RequestMethod.GET)
	public String triggermail(@PathVariable String mail) {
		
		
		return service.sendSimpleEmail(mail, "Message send from admin", "Request accepted you'll be contacted by washer shortly for pickup");
	}
	@DeleteMapping("/deleteorder/{id}")
	public String deleteorder(@PathVariable String id)
	{
		repository.deleteById(id);
		return "Order deleted successfully";
	}
	
	
}
