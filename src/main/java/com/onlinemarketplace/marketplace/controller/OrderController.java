package com.onlinemarketplace.marketplace.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.dto.OrderDto;
import com.onlinemarketplace.marketplace.model.Order;
import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.Product;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.OrderRepository;
import com.onlinemarketplace.marketplace.repositories.ProductRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	OrderHistoryRepository orderHistoryRepository;
	
	

//	@PostMapping
//	public Order createOrder(@RequestBody Order order) {
//		User user = userRepository.findById(order.getUser().getId()).orElse(null);
//		List<Product> products = order.getProducts();
//		for (Product product : products) {
//			product = productRepository.findById(product.getId()).orElse(null);
//		}
//		order.setUser(user);
//		order.setProducts(products);
//		return orderRepository.save(order);
//	}

//	@PostMapping("/users/{userId}/orders")
//	public Order createOrder(@PathVariable String userId, @RequestBody Order order) {
//	    // Find the user by ID and set it in the order object
//	    User user = userRepository.findById(userId).orElse(null);                   // handle the exception
//	    order.setUser(user);
//
//	    // Create a new list of products that will be updated with the latest product information
//	    List<Product> updatedProducts = new ArrayList<>();
//
//	    // Iterate through the list of products in the order object
//	    for (Product product : order.getProducts()) {
//	        // Find the product by ID in the product repository
//	        Product updatedProduct = productRepository.findById(product.getId()).orElse(null);   // exception
//	        
//	        // If the product exists in the repository, update its data in the order object
//	        if (updatedProduct != null) {
//	            // Set the product data in the order object
//	            product.setProductName(updatedProduct.getProductName());
//	            product.setProductPrice(updatedProduct.getProductPrice());
//
//	            // Add the updated product to the list of products
//	            updatedProducts.add(product);
//	        }
//	    }
//
//	    // Set the updated list of products in the order object
//	    order.setProducts(updatedProducts);
//
//	    // Save the order object to the order repository and return it
//	    return orderRepository.save(order);
//	}

	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<OrderDto>createOrder(@PathVariable ObjectId userId, @RequestBody OrderDto orderDto) {
		return new ResponseEntity<OrderDto>( orderService.createOrder(userId,orderDto), HttpStatus.CREATED);
/*	
		
		// Find the user by ID and set it in the order object
		User user = userRepository.findById(userId).orElse(null); // handle exception
		order.setUser(user);

		// Create a new list of products that will be updated with the latest product
		// information
		List<Product> updatedProducts = new ArrayList<>();

		// Iterate through the list of products in the order object
		for (Product product : order.getProducts()) {
			// Find the product by ID in the product repository
			Product updatedProduct = productRepository.findById(product.getId()).orElse(null); // handle exception

			// If the product exists in the repository, update its data in the order object
			if (updatedProduct != null) {
				// Set the product data in the order object
				product.setProductName(updatedProduct.getProductName());
				product.setProductPrice(updatedProduct.getProductPrice());

				// Add the updated product to the list of products
				updatedProducts.add(product);
			}
		}

		// Set the updated list of products in the order object
		order.setProducts(updatedProducts);

		// Save the order object to the order repository
		Order savedOrder = orderRepository.save(order);

		// Add the order to the user's order history
		List<OrderHistory> orderHistories = user.getOrderHistories(); // get the user's order histories
		OrderHistory orderHistory = null; // declare a variable to store the OrderHistory object
		if (orderHistories != null && orderHistories.size() > 0) {
			// If the user has an existing order history, get the last one
			orderHistory = orderHistories.get(orderHistories.size() - 1);
		}

		if (orderHistory == null) {
			// If the user doesn't have an existing order history, create a new one and set
			// it to the user
			orderHistory = new OrderHistory();
			orderHistory.setUser(user);
			user.setOrderHistories(new ArrayList<>(Arrays.asList(orderHistory)));
		}

		// Add the savedOrder to the user's order history
		orderHistory.getOrders().add(savedOrder);
		orderHistoryRepository.save(orderHistory);
		userRepository.save(user);

		

		// Return the saved order object
		return savedOrder;
*/
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDto>getOrderById(@PathVariable ObjectId id) {
		return new ResponseEntity<OrderDto>(orderService.getOrderByUserId(id),HttpStatus.OK);
	}
}
