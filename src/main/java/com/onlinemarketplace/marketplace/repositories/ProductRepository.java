package com.onlinemarketplace.marketplace.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlinemarketplace.marketplace.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	
	Product findByProductName(String productName);

}
