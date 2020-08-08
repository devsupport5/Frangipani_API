package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{
	
	@Query("SELECT u FROM UserAddress u WHERE u.userId = ?1")
	List<UserAddress> getUserAddress(Long userId);
	
	@Query("SELECT u FROM UserAddress u WHERE u.userEmail = ?1")
	List<UserAddress> getGuestUserAddress(String emailAddress);
	
	
}
