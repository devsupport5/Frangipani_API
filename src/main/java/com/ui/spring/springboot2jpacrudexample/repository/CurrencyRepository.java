package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>{
	 
	@Query("SELECT u FROM Currency u WHERE u.isDefault = 1")
	List<Currency> getDefaultCurrency();
	
}
