package com.onlinemarketplace.marketplace.service;

import org.bson.types.ObjectId;

import com.onlinemarketplace.marketplace.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto getUsreById(ObjectId id);

	UserDto updateUserById(ObjectId id, UserDto userDto);

	UserDto deleteUserById(ObjectId id);

}
