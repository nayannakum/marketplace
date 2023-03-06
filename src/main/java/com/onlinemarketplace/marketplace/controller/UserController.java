package com.onlinemarketplace.marketplace.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;

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
	@Autowired OrderHistoryRepository orderHistoryRepository;

	@PostMapping
	public User createUser(@RequestBody User user) {
		
		if(user.getAddress()!= null) {
			
			user.getAddress().stream().forEach(address -> {
				address.setUser(user);
				addressRepository.save(address);
				
				
			});
		}
		

		return userRepository.save(user);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) {
		User user = userRepository.findById(id).get();
//		List<OrderHistory> findByUser = orderHistoryRepository.findByUser(user);
//		user.setOrderHistories(findByUser);
//		System.out.println(findByUser);
		return user;
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
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
	public String deleteUser(@PathVariable String id) {
		userRepository.deleteById(id);
		return "user is deleted with id : " + id;
	}

}
