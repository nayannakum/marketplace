package com.onlinemarketplace.marketplace;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class MarketplaceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired AddressRepository addressRepository;
	@Autowired UserRepository userRepository;
	@Autowired OrderHistoryRepository orderHistoryRepository;
	@Test
	public void getAddress(String id) {

         System.out.println(orderHistoryRepository.findByUser(userRepository.findById(id).get()));
		
	}
}
