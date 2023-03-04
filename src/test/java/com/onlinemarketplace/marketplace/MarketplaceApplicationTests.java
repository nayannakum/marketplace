package com.onlinemarketplace.marketplace;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.repositories.AddressRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class MarketplaceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired AddressRepository addressRepository;
	@Autowired UserRepository UserRepository;
	@Test
	public void getAddress(String id) {

		List<Address> list = addressRepository.findByUser(UserRepository.findById("2").get());
		System.out.println(list);
		
	}
}
