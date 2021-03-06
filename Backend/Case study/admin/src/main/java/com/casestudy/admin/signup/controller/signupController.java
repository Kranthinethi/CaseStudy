package com.casestudy.admin.signup.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.admin.signup.model.admin;
import com.casestudy.admin.signup.repository.adminRepository;
import com.casestudy.admin.signup.service.SequenceGeneratorService;




@RestController
@RequestMapping("/admin")
public class signupController {


	@Autowired
    private  adminRepository  repository;
	
	@Autowired
	private SequenceGeneratorService service;
	

	@PostMapping("/addAdmin")
	public String saveUserDetails(@RequestBody admin admin) throws DuplicateKeyException
	{
		try {
			admin.setId(service.getSequenceNumber(admin.SEQUENCE_NAME));
		
		repository.save(admin);
		
		return "Admin added successfully with id "+admin.getId();
		}
		catch(DuplicateKeyException e)
		{
			return "User Registration Failed-Email Already Exists";
		}
	}
	@GetMapping("/findAll")
	public List<admin> getUserDetails(){
		return repository.findAll();
	}
	
	@GetMapping("/findAll/{id}")
	public Optional<admin> getUser(@PathVariable int id){
		return repository.findById(id);
	}
	
	@GetMapping("/findByEmailId/{emailId}")
	public List<admin> getUserByemail(@PathVariable String emailId)
	{
		return repository.findByEmailId(emailId);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id)
	{
		repository.deleteById(id);
		return "User deleted with id:"+id;
	}
	
}
