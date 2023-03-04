package com.onlinemarketplace.marketplace.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.User;

public interface AddressRepository extends MongoRepository<Address, String> {

    @Query("{ 'user.$id' : ?0 }")
    List<Address> findByUserId(String userId);
	
    @Query("{ 'user' : ?0 }")
    List<Address> findByUser(User user);
    
    @Query("{ 'user.$id' : ?0 }")
    List<Address> deleteByUserId(String userId);
}
