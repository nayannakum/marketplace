package com.onlinemarketplace.marketplace.service;

import java.util.List;

import com.onlinemarketplace.marketplace.dto.AddressDto;
import com.onlinemarketplace.marketplace.model.Address;

public interface AddressService {

	List<AddressDto> findByUserId(String userId);

}
