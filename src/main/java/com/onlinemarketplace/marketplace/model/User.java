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
import lombok.ToString;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private ObjectId id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

	private String gender;
	
	@DBRef
	@JsonIgnore
	private List<Address> address = new ArrayList<>();
	
	@DBRef
	@JsonIgnore
	private List<OrderHistory> orderHistories;
	
	
}
