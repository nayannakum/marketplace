package com.onlinemarketplace.marketplace.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Address implements Serializable {

	@Id
	private String id;

	private String city;

	private String state;

	private String pincode;

	@DBRef
	@JsonIgnore
	private User user;
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String id, String city, String state, String pincode, User user) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
