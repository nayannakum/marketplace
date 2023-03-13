package com.onlinemarketplace.marketplace.payloads;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class OrderHistoryDto {

	private ObjectId id;
	@JsonIgnore
	private UserDto user;
	private List<OrderDto> orders = new ArrayList<OrderDto>();

	

}
