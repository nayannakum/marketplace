package com.onlinemarketplace.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

	@Autowired
	UserService userService;

	@Autowired
	AddressService addressService;

	@GetMapping("/users/{userId}/addresses")
	public ResponseEntity<List<AddressDto>> getAllAddressesByUserId(@PathVariable ObjectId userId) {
		return new ResponseEntity<List<AddressDto>>(addressService.findByUserId(userId), HttpStatus.OK);
	}

	@GetMapping("/users/{userId}/addresses/{addressId}")
	public ResponseEntity<AddressDto> getAddressById(@PathVariable ObjectId userId, @PathVariable String addressId) {
		return new ResponseEntity<AddressDto>(addressService.findByIdandUserId(userId, addressId), HttpStatus.OK);

	}

	@PostMapping("/users/{userId}/addresses")
	public ResponseEntity<AddressDto> createAddress(@PathVariable ObjectId userId, @RequestBody AddressDto addressDto) {
		return new ResponseEntity<AddressDto>(addressService.createNewAddressWithUser(userId, addressDto),
				HttpStatus.OK);
	}

	@PutMapping("/users/{userId}/addresses/{addressId}")
	public ResponseEntity<AddressDto> updateAddress(@PathVariable ObjectId userId, @PathVariable String addressId,
			@RequestBody AddressDto addressDetails) {

		return new ResponseEntity<AddressDto>(
				addressService.updateAddressByUserAndAddressId(userId, addressDetails, addressId), HttpStatus.OK);
	}

}
