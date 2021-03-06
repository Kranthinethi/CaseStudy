package com.casestudy.admin.orders.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "orderDetails")
public class OrderDetails {
 
	@Id
	@Field("OrderId")
    public String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String customerId ;
    public String customername;
  
    public String customeremaiId;
    public car cardetails;
    public carwashers washer;
    public String status;

	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeremaiId() {
		return customeremaiId;
	}
	public void setCustomeremaiId(String customeremaiId) {
		this.customeremaiId = customeremaiId;
	}
	public car getCardetails() {
		return cardetails;
	}
	public void setCardetails(car cardetails) {
		this.cardetails = cardetails;
	}
	public carwashers getWasher() {
		return washer;
	}
	public void setWasher(carwashers washer) {
		this.washer = washer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
