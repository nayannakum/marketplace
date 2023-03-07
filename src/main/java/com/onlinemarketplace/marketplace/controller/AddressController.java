package com.onlinemarketplace.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.dto.AddressDto;
import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.AddressService;
import com.onlinemarketplace.marketplace.service.UserService;

@RestController
public class AddressController {

//	@Autowired
//	private AddressRepository addressRepository;
//	
//	@Autowired UserRepository userRepository;
	
	@Autowired UserService userService;
	
	@Autowired AddressService addressService;
	
	
	@GetMapping("/users/{userId}/addresses")
	public  ResponseEntity <List<AddressDto>> getAllAddressesByUserId(@PathVariable String userId) {
		
		//find user and if not throw exception
		
	    return new ResponseEntity<List<AddressDto>>(addressService.findByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}/addresses/{addressId}")
	public Address getAddressById(@PathVariable String userId, @PathVariable String addressId) {
	    return addressRepository.findByIdAndUserId(addressId, userId).get(); // exception handle
	}
	
	@PostMapping("/users/{userId}/addresses")
	public Address createAddress(@PathVariable String userId, @RequestBody Address address) {
		User user = userRepository.findById(userId).get(); // exception handle
	    address.setUser(user); // set the user ID in the address object
	    return addressRepository.save(address);
	}
	@PutMapping("/users/{userId}/addresses/{addressId}")
	public Address updateAddress(@PathVariable String userId, @PathVariable String addressId, @RequestBody Address addressDetails) {
	    Address address = addressRepository.findByIdAndUserId(addressId, userId).get();
//	            .orElseThrow(() -> new ResourceNotFoundException("Address not found with id " + addressId));
	    address.setCity(addressDetails.getCity());
	    address.setState(addressDetails.getState());
	    address.setPincode(addressDetails.getPincode());
	    return addressRepository.save(address);
	}
	
}
