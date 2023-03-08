package com.onlinemarketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "orderHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory {

	@Id
	private ObjectId id;
	@DBRef
	@JsonIgnore
	private User user;
	@DBRef
	private List<Order> orders = new ArrayList<Order>();


}
