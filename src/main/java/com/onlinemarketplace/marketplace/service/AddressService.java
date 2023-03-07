package com.onlinemarketplace.marketplace.service;

import java.util.List;

import com.onlinemarketplace.marketplace.model.Address;

public interface AddressService {

	List<Address> findByUserId(String userId);

}
