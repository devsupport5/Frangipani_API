package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	/*@Query("SELECT u FROM Category u WHERE u.parentId = 0 order by categoryName")
	List<Category> getAllCategorys();*/
	
	@Query("SELECT u FROM Order u WHERE u.userId = ?1")
	List<Order> getUserOrdersHistory(Long userId);
}
