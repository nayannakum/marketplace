package com.onlinemarketplace.marketplace.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlinemarketplace.marketplace.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	
	Optional<Product>findByProductName(String productName);

}
