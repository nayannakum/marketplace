package com.onlinemarketplace.marketplace.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

	@Id
	private String id;

	private String city;

	private String state;

	private String pincode;

	@DBRef
	@JsonIgnore
	private User user;
}
