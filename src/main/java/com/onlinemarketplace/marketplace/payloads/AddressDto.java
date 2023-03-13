package com.onlinemarketplace.marketplace.payloads;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class AddressDto {

	private String id;

	private String city;

	private String state;

	private String pincode;
	@JsonIgnore
	@DBRef
	private UserDto user;

	
	

}
