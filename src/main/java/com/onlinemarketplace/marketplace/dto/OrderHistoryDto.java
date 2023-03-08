package com.onlinemarketplace.marketplace.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class OrderHistoryDto {

	private ObjectId id;
	@JsonIgnore
	private UserDto user;
	private List<OrderDto> orders = new ArrayList<OrderDto>();

	

}
