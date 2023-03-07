package com.onlinemarketplace.marketplace.dto;

import java.util.List;

import org.bson.types.ObjectId;


public class UserDto {

	private ObjectId id;
	
	private String name;

	private String gender;
	
	private List<AddressDto> address;
	
	private List<OrderHistoryDto> orderHistories;

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

	public List<AddressDto> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDto> address) {
		this.address = address;
	}

	public List<OrderHistoryDto> getOrderHistories() {
		return orderHistories;
	}

	public void setOrderHistories(List<OrderHistoryDto> orderHistories) {
		this.orderHistories = orderHistories;
	}

	public UserDto(ObjectId id, String name, String gender, List<AddressDto> address,
			List<OrderHistoryDto> orderHistories) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.orderHistories = orderHistories;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
