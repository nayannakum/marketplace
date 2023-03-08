package com.onlinemarketplace.marketplace.dto;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class OrderDto {

	private ObjectId id;
	
	@JsonIgnore
	private UserDto user;
	
	private List<ProductDto> products;

	
}
