package com.onlinemarketplace.marketplace.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.marketplace.payloads.OrderDto;
import com.onlinemarketplace.marketplace.exception.MarketPlaceException;
import com.onlinemarketplace.marketplace.exception.ResourceNotFoundException;
import com.onlinemarketplace.marketplace.model.Order;
import com.onlinemarketplace.marketplace.model.OrderHistory;
import com.onlinemarketplace.marketplace.model.Product;
import com.onlinemarketplace.marketplace.model.User;
import com.onlinemarketplace.marketplace.repositories.OrderHistoryRepository;
import com.onlinemarketplace.marketplace.repositories.OrderRepository;
import com.onlinemarketplace.marketplace.repositories.ProductRepository;
import com.onlinemarketplace.marketplace.repositories.UserRepository;
import com.onlinemarketplace.marketplace.service.OrderService;
@Service
public class OrderServiceimpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	OrderHistoryRepository orderHistoryRepository;
	@Autowired
	ModelMapper mapper;

	@Override
	public OrderDto createOrder(ObjectId userId, OrderDto orderDto) {
		
		

		// Find the user by ID and set it in the order object
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		if(user.getAddress()==null) {
			throw new MarketPlaceException(HttpStatus.BAD_REQUEST,"please enter user address first");
		}
		Order order = mapper.map(orderDto, Order.class);

		order.setUser(user);

		// Create a new list of products that will be updated with the latest product
		// information
		List<Product> updatedProducts = new ArrayList<>();

		// Iterate through the list of products in the order object
		for (Product product : order.getProducts()) {
			// Find the product by ID in the product repository

			Product updatedProduct = productRepository.findById(product.getId())
					.orElseThrow(() -> new ResourceNotFoundException("product", product.getId()));

			
			// If the product exists in the repository, update its data in the order object
			if (updatedProduct != null) {
				// Set the product data in the order object
				product.setProductName(updatedProduct.getProductName());
				product.setProductPrice(updatedProduct.getProductPrice());

				// Add the updated product to the list of products
				updatedProducts.add(product);
			}
		}

		// Set the updated list of products in the order object
		order.setProducts(updatedProducts);

		// Save the order object to the order repository
		Order savedOrder = orderRepository.save(order);

		// Add the order to the user's order history
		List<OrderHistory> orderHistories = user.getOrderHistories(); // get the user's order histories
		OrderHistory orderHistory = null; // declare a variable to store the OrderHistory object
		if (orderHistories != null && orderHistories.size() > 0) {
			// If the user has an existing order history, get the last one
			orderHistory = orderHistories.get(orderHistories.size() - 1);
		}

		if (orderHistory == null) {
			// If the user doesn't have an existing order history, create a new one and set
			// it to the user
			orderHistory = new OrderHistory();
			orderHistory.setUser(user);
			user.setOrderHistories(new ArrayList<>(Arrays.asList(orderHistory)));
		}

		// Add the savedOrder to the user's order history
		orderHistory.getOrders().add(savedOrder);
		orderHistoryRepository.save(orderHistory);
		userRepository.save(user);

		return mapper.map(savedOrder, OrderDto.class);
	}

	@Override
	public OrderDto getOrderByUserId(ObjectId id) {
		Order order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("order", "id",id));
		return mapper.map(order, OrderDto.class);
	}
}
