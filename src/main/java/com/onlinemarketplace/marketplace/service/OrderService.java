package com.onlinemarketplace.marketplace.service;

import org.bson.types.ObjectId;

import com.onlinemarketplace.marketplace.payloads.OrderDto;

public interface OrderService {

	OrderDto createOrder(ObjectId userId, OrderDto orderDto);

	OrderDto getOrderByUserId(ObjectId id);

}
