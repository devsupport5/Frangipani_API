package com.ui.spring.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.PaypalTransaction;

@Repository
public interface PaypalTransactionRepository extends JpaRepository<PaypalTransaction, Long>{

	/*@Query("SELECT u FROM Author u WHERE u.isActive = 0")
	List<Author> getActiveAuthors();*/
	
	
	
}
