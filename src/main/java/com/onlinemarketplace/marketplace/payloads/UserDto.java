package com.onlinemarketplace.marketplace.payloads;

import java.util.List;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDto {

	private ObjectId id;
	
	private String name;

	private String gender;
	
	private List<AddressDto> address;
	
	@JsonIgnore
	private List<OrderHistoryDto> orderHistories;
	
}
