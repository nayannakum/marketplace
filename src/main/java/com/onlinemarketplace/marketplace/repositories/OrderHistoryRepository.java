package com.onlinemarketplace.marketplace.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.User;

public interface OrderHistoryRepository extends MongoRepository<OrderHistory, ObjectId> {

//		@Query("{ 'user' : ?0 }")
//		OrderHistory findByUser(User user);
	
//		@Query("{ 'user.id' : ?0 }")
//	    List<OrderHistory> findByUser(User user);
		
//		OrderHistory findByUser(User user);
		List<OrderHistory> findByUser(User user);
}
