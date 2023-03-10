package com.onlinemarketplace.marketplace.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.onlinemarketplace.marketplace.payloads.OrderHistoryDto;

public interface OrderHistoryService {

	List<OrderHistoryDto> getHistory(ObjectId userId);

}
