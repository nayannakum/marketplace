package com.onlinemarketplace.marketplace.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.marketplace.payloads.AddressDto;
import com.onlinemarketplace.marketplace.exception.ResourceNotFoundException;
import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper mapper;

	@Override
	public List<AddressDto> findByUserId(ObjectId objectId) {

		User user = userRepository.findById(objectId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", objectId));
		List<Address> addresses = user.getAddress();
		return addresses.stream().map(address -> mapToDto(address)).collect(Collectors.toList());
	}

	public AddressDto mapToDto(Address address) {
		return mapper.map(address, AddressDto.class);
	}

	@Override
	public AddressDto findByIdandUserId(ObjectId userId, String addressId) {
		Address address = addressRepository.findByIdAndUserId(addressId, userId).orElseThrow(() -> new ResourceNotFoundException("address", "id", userId));
		return mapper.map(address, AddressDto.class);
	}

	@Override
	public AddressDto createNewAddressWithUser(ObjectId userId, AddressDto addressDto) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		Address address = mapper.map(addressDto, Address.class);
		user.getAddress().add(address);
		return mapper.map(address, AddressDto.class);
	}

	@Override
	public AddressDto updateAddressByUserAndAddressId(ObjectId userId, AddressDto addressDetails, String addressId) {
		Address address = addressRepository.findByIdAndUserId(addressId, userId).orElseThrow(()->new ResourceNotFoundException("address", "id", userId));
		  address.setCity(addressDetails.getCity());
		    address.setState(addressDetails.getState());
		    address.setPincode(addressDetails.getPincode());
		    Address updatedAddress = addressRepository.save(address);
		return mapper.map(updatedAddress, AddressDto.class);
	}


}











