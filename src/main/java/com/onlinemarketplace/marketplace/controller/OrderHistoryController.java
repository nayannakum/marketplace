package com.onlinemarketplace.marketplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.dto.OrderHistoryDto;
import com.onlinemarketplace.marketplace.model.Order;
import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.OrderHistoryService;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {

	@Autowired
	private OrderHistoryService orderHistoryService;

//	    @GetMapping("/{userId}")
//	    public ResponseEntity<List<OrderHistory>> getOrderHistoryByUserId(@PathVariable String userId) {
//	        User user = userRepository.findById(userId).get();					//exception handling
//	       List<OrderHistory> findByUser = orderHistoryRepository.findByUser(user);  // exception handling
//	       System.out.println(findByUser);
//	        	return new ResponseEntity<>(findByUser, HttpStatus.OK);
//
//	    }
	@GetMapping("/orderHistory/{userId}")
	public ResponseEntity<List<OrderHistoryDto>> getOrderHistoryByUserId(@PathVariable ObjectId userId) {
		return new ResponseEntity<List<OrderHistoryDto>>(orderHistoryService.getHistory(userId), HttpStatus.OK);

	}

}
