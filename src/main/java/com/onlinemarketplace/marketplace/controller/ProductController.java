package com.onlinemarketplace.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.dto.ProductDto;
import com.onlinemarketplace.marketplace.model.Product;
import com.onlinemarketplace.marketplace.repositories.ProductRepository;
import com.onlinemarketplace.marketplace.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/id/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable String id) {
		return new ResponseEntity<ProductDto>(productService.getProductById(id), HttpStatus.OK);
	}

	@GetMapping("/name/{productName}")
	public ResponseEntity<ProductDto> getProductByName(@PathVariable String productName) {
		return new ResponseEntity<ProductDto>(productService.findByName(productName),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>(productService.createNewProduct(productDto),HttpStatus.OK);
	}

}
