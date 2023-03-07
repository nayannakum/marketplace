package com.onlinemarketplace.marketplace.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlinemarketplace.marketplace.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findById(ObjectId objectId);

	void deleteById(ObjectId id);

}
