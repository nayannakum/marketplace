package com.onlinemarketplace.marketplace.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.onlinemarketplace.marketplace.dto.OrderHistoryDto;
import com.onlinemarketplace.marketplace.model.OrderHistory;

public interface OrderHistoryService {

	List<OrderHistoryDto> getHistory(ObjectId userId);

}
