package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Order;
import com.ui.spring.springboot2jpacrudexample.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{

 
	@Autowired
	private OrderRepository  orderRepository;
	
	@Override
	public List<Order> getAllOrders() {
		return this.orderRepository.findAll();
	}

	@Override
	public Optional<Order> getOrderById(Long sliderId) {
		return this.orderRepository.findById(sliderId);
	}

	@Override
	public Order createOrder(Order order) {
		return this.orderRepository.save(order);
	}

	@Override
	public List<Order> getUserOrdersHistory(Integer userId) {
		// TODO Auto-generated method stub
		return this.orderRepository.getUserOrdersHistory(userId);
	}

}
