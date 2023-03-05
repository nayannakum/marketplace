package com.onlinemarketplace.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {

	
		@Autowired
	    private OrderHistoryRepository orderHistoryRepository;
	 
		@Autowired 
		UserRepository userRepository;

	    @GetMapping("/{userId}")
	    public ResponseEntity<OrderHistory> getOrderHistoryByUserId(@PathVariable String userId) {
	        User user = userRepository.findById(userId).get();					//exception handling
	        OrderHistory orderHistory = orderHistoryRepository.findByUser(user);  // exception handling
	        System.out.println(orderHistoryRepository.findByUserId("3"));
	        	return ResponseEntity.ok(orderHistory);
	        
	    }
}
