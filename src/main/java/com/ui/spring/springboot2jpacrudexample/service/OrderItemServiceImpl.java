package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.OrderItems;
import com.ui.spring.springboot2jpacrudexample.repository.OrderItemRepository;


@Service
public class OrderItemServiceImpl implements OrderItemService{

 
	@Autowired
	private OrderItemRepository  orderItemRepository;
	
	@Override
	public List<OrderItems> getAllOrderItems() {
		return this.orderItemRepository.findAll();
	}

	@Override
	public Optional<OrderItems> getOrderItemsById(Long sliderId) {
		return this.orderItemRepository.findById(sliderId);
	}

	@Override
	public OrderItems createOrderItem(OrderItems OrderItem) {
		return this.orderItemRepository.save(OrderItem);
	}

	@Override
	public List<OrderItems> getUserOrderItemsHistory(Long userId) {
		// TODO Auto-generated method stub
		return orderItemRepository.getUserOrderItemsHistory(userId);
	}

	

}
