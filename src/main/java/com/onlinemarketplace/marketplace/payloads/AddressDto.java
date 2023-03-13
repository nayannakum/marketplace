package com.onlinemarketplace.marketplace.payloads;

import java.io.Serializable;

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
