package com.onlinemarketplace.marketplace.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlinemarketplace.marketplace.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
