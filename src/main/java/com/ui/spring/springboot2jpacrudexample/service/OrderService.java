package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Order;

public interface OrderService {
	
	List<Order> getAllOrders();
	
	List<Order> getUserOrdersHistory(Long userId);

	Optional<Order> getOrderById(Long sliderId);

	Order createOrder(Order order);	

	Order updateOrderStatus(Order order);
		
}
