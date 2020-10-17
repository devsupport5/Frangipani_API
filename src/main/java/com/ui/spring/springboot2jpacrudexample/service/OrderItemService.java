package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.OrderItems;

public interface OrderItemService {
	
	List<OrderItems> getAllOrderItems();
	
	List<OrderItems> getUserOrderItemsHistory(Long orderId);

	Optional<OrderItems> getOrderItemsById(Long sliderId);

	OrderItems createOrderItem(OrderItems OrderItem);	

		
}
