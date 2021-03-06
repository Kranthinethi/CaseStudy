package com.casestudy.CarWasher.signUp.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.CarWasher.signUp.models.carwashers;
import com.casestudy.CarWasher.signUp.repository.carWasherRepository;
import com.casestudy.CarWasher.signUp.services.SequenceGeneratorService;

@RestController
@RequestMapping("/washer")
@CrossOrigin(origins = "*")
public class signupController {


	@Autowired
    private  carWasherRepository repository;
	
	@Autowired
	private SequenceGeneratorService service;
	

	@PostMapping("/addWasher")
	public String saveUserDetails(@RequestBody carwashers carwasher) throws DuplicateKeyException
	{
		try {
			carwasher.setId(service.getSequenceNumber(carwasher.SEQUENCE_NAME));
		
		repository.save(carwasher);
		
		return "Washer added successfully with id "+carwasher.getId();
		}
		catch(DuplicateKeyException e)
		{
			return "Washer Registration Failed-Email Already Exists";
		}
	}
	@GetMapping("/findAll")
	public List<carwashers> getWasherDetails(){
		return repository.findAll();
	}
	
	@GetMapping("/findAll/{id}")
	public Optional<carwashers> getWasher(@PathVariable int id){
		return repository.findById(id);
	}
	
	@GetMapping("/findByEmailId/{emailId}")
	public List<carwashers> getUserByemail(@PathVariable String emailId)
	{
		return repository.findByEmailId(emailId);
	}
	
	@PutMapping("/update/{id}")
	public String updateByEmailId(@PathVariable int id,@RequestBody carwashers updatedcarwasher ) {
		Optional<carwashers> findwasher=repository.findById(id);
		carwashers washervalues=findwasher.get();
		washervalues.setCarwashname(updatedcarwasher.getCarwashname());
		if(updatedcarwasher.getEmailId()!=washervalues.getEmailId()) {
		washervalues.setEmailId(updatedcarwasher.getEmailId());}
		washervalues.setAddress(updatedcarwasher.getAddress());
		washervalues.setPhone(updatedcarwasher.getPhone());
		repository.save(washervalues);
		
		return "Details updated successfully";
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id)
	{
		repository.deleteById(id);
		return "User deleted with id:"+id;
	}
	
	@GetMapping("/test")
	public String testmicroservice() {
		return "String returned from carwasher";
	}
	
}
