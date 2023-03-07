package com.onlinemarketplace.marketplace.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinemarketplace.marketplace.dto.AddressDto;
import com.onlinemarketplace.marketplace.exception.ResourceNotFoundException;
import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.AddressService;

public class AddressServiceImpl implements AddressService {

	@Autowired AddressRepository addressRepository;
	@Autowired UserRepository userRepository ; 
	@Override
	public List<AddressDto> findByUserId(String userId) {
		
		userRepository.findById(userId).orElse(() -> throw new ResourceNotFoundException(resourceName, fieldName, fieldValue))
		
		return	addressRepository.findByUserId(userId);
	}

}
