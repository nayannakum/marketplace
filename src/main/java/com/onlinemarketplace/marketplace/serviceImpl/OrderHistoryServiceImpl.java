package com.onlinemarketplace.marketplace.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.marketplace.payloads.OrderHistoryDto;
import com.onlinemarketplace.marketplace.exception.ResourceNotFoundException;
import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.OrderHistoryService;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	private OrderHistoryRepository orderHistoryRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<OrderHistoryDto> getHistory(ObjectId userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		List<OrderHistory> orderHisotries = orderHistoryRepository.findByUser(user);
		return orderHisotries.stream().map(history -> mapper.map(history, OrderHistoryDto.class))
				.collect(Collectors.toList());

	}

}
