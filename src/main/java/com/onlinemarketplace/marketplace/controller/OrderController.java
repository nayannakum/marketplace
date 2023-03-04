package com.onlinemarketplace.marketplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.model.Order;
import com.onlinemarketplace.marketplace.model.Product;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.OrderRepository;
import com.onlinemarketplace.marketplace.repositories.ProductRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

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

	@PostMapping("/users/{userId}/orders")
	public Order createOrder(@PathVariable String userId, @RequestBody Order order) {
	    // Find the user by ID and set it in the order object
	    User user = userRepository.findById(userId).orElse(null);                   // handle the exception
	    order.setUser(user);

	    // Create a new list of products that will be updated with the latest product information
	    List<Product> updatedProducts = new ArrayList<>();

	    // Iterate through the list of products in the order object
	    for (Product product : order.getProducts()) {
	        // Find the product by ID in the product repository
	        Product updatedProduct = productRepository.findById(product.getId()).orElse(null);   // exception
	        
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

	    // Save the order object to the order repository and return it
	    return orderRepository.save(order);
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable ObjectId id) {
		return orderRepository.findById(id).get();
	}
}
