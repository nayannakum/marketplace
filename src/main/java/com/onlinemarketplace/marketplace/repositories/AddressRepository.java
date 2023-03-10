package com.onlinemarketplace.marketplace.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinemarketplace.marketplace.model.Address;
import com.onlinemarketplace.marketplace.model.User;
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

    @Query("{ 'user.$id' : ?0 }")
    List<Address> findByUserId(String userId);
	
    @Query("{ 'user' : ?0 }")
    List<Address> findByUser(User user);
    
    @Query("{'id': ?0, 'user.id': ?1}")
    Optional<Address> findByIdAndUserId(String addressId, ObjectId userId);
    
    
    @Query("{ 'user.$email' : ?0 }")
    List<Address> findByUserEmail(String email);
}
