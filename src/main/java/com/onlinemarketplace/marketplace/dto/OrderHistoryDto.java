package com.onlinemarketplace.marketplace.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "orderHistory")
public class OrderHistoryDto {

	@Id
	private ObjectId id;
	@DBRef
	@JsonIgnore
	private UserDto user;
	@DBRef
	private List<OrderDto> orders = new ArrayList<OrderDto>();
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}



}
