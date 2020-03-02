package com.example.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Person. ")
public class Person {
	
	@ApiModelProperty(notes = "The person first name")
	private String name;
	
	@ApiModelProperty(notes = "The person last name")
	private String lastname;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
