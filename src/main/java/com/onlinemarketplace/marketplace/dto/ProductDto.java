package com.onlinemarketplace.marketplace.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
public class ProductDto {

	private String id;
	
	private String productName;
	
	private String productPrice;

	
}
