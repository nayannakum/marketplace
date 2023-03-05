package com.onlinemarketplace.marketplace.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderHistory")
public class OrderHistory {

	@Id
	private ObjectId id;
	@DBRef
	private User user;
	@DBRef
	private List<Order> orders;

	public ObjectId getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderHistory(User user, List<Order> orders) {
		super();
		this.user = user;
		this.orders = orders;
	}

	public OrderHistory() {
		super();
	}

	@Override
	public String toString() {
		return "OrderHistory [id=" + id + ", user=" + user + ", orders=" + orders + "]";
	}

//	public OrderHistory(User user2, Object object) {
//		// TODO Auto-generated constructor stub
//	}
	

}
