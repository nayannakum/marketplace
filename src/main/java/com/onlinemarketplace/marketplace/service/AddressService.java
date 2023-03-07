package com.onlinemarketplace.marketplace.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.onlinemarketplace.marketplace.dto.AddressDto;
public interface AddressService {

	List<AddressDto> findByUserId(ObjectId userId);

}
