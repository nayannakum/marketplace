package com.onlinemarketplace.marketplace.service;

import com.onlinemarketplace.marketplace.payloads.ProductDto;

public interface ProductService {

	ProductDto getProductById(String id);

	ProductDto findByName(String productName);

	ProductDto createNewProduct(ProductDto productDto);

}
