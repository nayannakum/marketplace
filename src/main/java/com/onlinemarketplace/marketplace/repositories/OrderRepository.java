package com.onlinemarketplace.marketplace.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlinemarketplace.marketplace.model.Order;

public interface OrderRepository extends MongoRepository<Order, ObjectId> {

}
