package com.onlinemarketplace.marketplace.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.payloads.OrderHistoryDto;
import com.onlinemarketplace.marketplace.service.OrderHistoryService;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {

	@Autowired
	private OrderHistoryService orderHistoryService;

	@GetMapping("/orderHistory/{userId}")
	public ResponseEntity<List<OrderHistoryDto>> getOrderHistoryByUserId(@PathVariable ObjectId userId) {
		return new ResponseEntity<List<OrderHistoryDto>>(orderHistoryService.getHistory(userId), HttpStatus.OK);

	}

}
