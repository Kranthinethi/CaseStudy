package com.casestudy.admin.orders.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class carwashers {
	 
	
	
	private int id;
	private String carwashname;
	private String password;
	private String emailId;
	private String address;
	private long phone;
	
	public int getId() {
		return id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCarwashname() {
		return carwashname;
	}
	public void setCarwashname(String carwashname) {
		this.carwashname = carwashname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}

