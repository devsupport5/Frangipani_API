package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.OrderItems;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Long>{

	/*@Query("SELECT u FROM Category u WHERE u.parentId = 0 order by categoryName")
	List<Category> getAllCategorys();*/
	
	@Query("SELECT u FROM OrderItems u WHERE u.orderId = ?1")
	List<OrderItems> getUserOrderItemsHistory(Long orderId);
}
