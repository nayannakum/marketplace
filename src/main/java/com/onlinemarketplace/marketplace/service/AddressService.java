package com.onlinemarketplace.marketplace.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.onlinemarketplace.marketplace.payloads.AddressDto;

public interface AddressService {

	List<AddressDto> findByUserId(ObjectId userId);

	AddressDto findByIdandUserId(ObjectId userId, String addressId);

	AddressDto createNewAddressWithUser(ObjectId userId, AddressDto addressDto);

	AddressDto updateAddressByUserAndAddressId(ObjectId userId, AddressDto addressDetails, String addressId);

	

}
