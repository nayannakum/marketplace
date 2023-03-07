package com.onlinemarketplace.marketplace.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.dto.UserDto;
import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@ApiIgnore
	@RequestMapping("/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;
//	@Autowired OrderHistoryRepository orderHistoryRepository;
	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(userService.createUser(userDto),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto>getUserById(@PathVariable ObjectId id) {
		return new ResponseEntity<UserDto>(userService.getUsreById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable ObjectId id, @RequestBody User user) {
		// find the user by id
		User existingUser = userRepository.findById(id).get();

		existingUser.setName(user.getName());
		existingUser.setGender(user.getGender());
		existingUser.setAddress(user.getAddress());
		// save the updated user
		User updatedUser = userRepository.save(existingUser);

		return updatedUser;
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable ObjectId id) {
		userRepository.deleteById(id);
		return "user is deleted with id : " + id;
	}

}
