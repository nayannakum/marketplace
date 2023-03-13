package com.onlinemarketplace.marketplace.serviceImpl;

import java.util.List;

import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.marketplace.payloads.UserDto;
import com.onlinemarketplace.marketplace.exception.ResourceNotFoundException;
import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	ModelMapper mapper;
	@Autowired AddressRepository addressRepository;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		userRepository.save(user);
		return	mapper.map(user, UserDto.class);
	}


	@Override
	public UserDto getUserById(ObjectId id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));
		return	mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto getUserByEmail(String email) {
		User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("user", email));
		return	mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUserById(ObjectId id, UserDto userDto) {
		User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		
		//set value from dto
		existingUser.setFirstName(userDto.getFirstName());
		existingUser.setLastName(userDto.getLastName());
		existingUser.setGender(userDto.getGender());

		// save the updated user
		User updatedUser = userRepository.save(existingUser);
		
		return mapper.map(updatedUser, UserDto.class);
	}


	@Override
	public UserDto deleteUserById(ObjectId id) {
		User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
		userRepository.deleteById(id);
		return mapper.map(user, UserDto.class);
	}
}
















