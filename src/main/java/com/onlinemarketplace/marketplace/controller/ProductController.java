package com.onlinemarketplace.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.model.Product;
import com.onlinemarketplace.marketplace.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired ProductRepository productRepository;
	
	@GetMapping("/id/{id}")
	public Product getProduct(@PathVariable String id) {
		return productRepository.findById(id).get(); // handle exception
	}
	
	@GetMapping("/name/{productName}")
	public Product getProductByName(@PathVariable String productName) {
		return productRepository.findByProductName(productName);
	}
	
//	@PostMapping
//	public Product createProduct(@RequestBody Product product) {
//		return productRepository.save(product);
//	}
	
	
	
}
