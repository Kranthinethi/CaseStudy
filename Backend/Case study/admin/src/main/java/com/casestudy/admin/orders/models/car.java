package com.casestudy.admin.orders.models;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@ToString

public class car {
	
	
	public String carnumber;
    public String brandname;
    public String model;
    public String category;
    public String carphoto;
    public String addonservice;
    public String location;
    public String comment;
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCarphoto() {
		return carphoto;
	}
	public void setCarphoto(String carphoto) {
		this.carphoto = carphoto;
	}
	public String getAddonservice() {
		return addonservice;
	}
	public void setAddonservice(String addonservice) {
		this.addonservice = addonservice;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
    
    
    
}
