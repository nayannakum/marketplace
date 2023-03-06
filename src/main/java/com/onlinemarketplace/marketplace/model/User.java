package com.onlinemarketplace.marketplace.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Document
public class User {

	@Id
	private ObjectId id;
	
	private String name;

	private String gender;
	
	@DBRef
	private List<Address> address;
	
	@DBRef
	private List<OrderHistory> orderHistories;
	

	public List<OrderHistory> getOrderHistories() {
		return orderHistories;
	}

	public void setOrderHistories(List<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(ObjectId id, String name, String gender, List<com.onlinemarketplace.marketplace.model.Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + ", orderHistories="
				+ orderHistories + "]";
	}
	
	
	
}
