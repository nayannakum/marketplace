package com.onlinemarketplace.marketplace.service;

import com.onlinemarketplace.marketplace.dto.ProductDto;

public interface ProductService {

	ProductDto getProductById(String id);

	ProductDto findByName(String productName);

	ProductDto createNewProduct(ProductDto productDto);

}
