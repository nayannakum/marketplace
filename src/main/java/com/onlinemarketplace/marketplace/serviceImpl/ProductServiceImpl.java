package com.onlinemarketplace.marketplace.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.onlinemarketplace.marketplace.dto.ProductDto;
import com.onlinemarketplace.marketplace.exception.ResourceNotFoundException;
import com.onlinemarketplace.marketplace.model.Product;
import com.onlinemarketplace.marketplace.repositories.ProductRepository;
import com.onlinemarketplace.marketplace.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired private ProductRepository productRepository;
	@Autowired private ModelMapper mapper;
	
	@Override
	public ProductDto getProductById(String id) {
		Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product", id));
		return mapper.map(product , ProductDto.class);
	}

	@Override
	public ProductDto findByName(String productName) {
		Product product = productRepository.findByProductName(productName).orElseThrow(()-> new ResourceNotFoundException("product", productName));;
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public ProductDto createNewProduct(ProductDto productDto) {
		Product product = mapper.map(productDto, Product.class);
		productRepository.save(product);
		return mapper.map(product, ProductDto.class);
	}

}
