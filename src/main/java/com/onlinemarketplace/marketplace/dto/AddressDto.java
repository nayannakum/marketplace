package com.onlinemarketplace.marketplace.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class AddressDto implements Serializable {

	private String id;

	private String city;

	private String state;

	private String pincode;
	@JsonIgnore
	private UserDto user;

	
	

}
