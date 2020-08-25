package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.UserAddress;
@Transactional
@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{
	
	@Query("SELECT u FROM UserAddress u WHERE u.userId = ?1 and u.isDeleted = 0")
	List<UserAddress> getUserAddress(Long userId);
	
	@Query("SELECT u FROM UserAddress u WHERE u.userEmail = ?1")
	List<UserAddress> getGuestUserAddress(String emailAddress);
	
	@Query("UPDATE UserAddress u SET  u.isDeleted = 1 WHERE u.id = ?1")
	void deleteAddressById(Long id);
	
	@Modifying
	@Query("UPDATE UserAddress u SET  u.defaultAddress = 1 WHERE u.id = ?1")
	void setDefaultAddressById(Long id);
	
	@Modifying
	@Query("UPDATE UserAddress u SET  u.defaultAddress = 0 WHERE u.userId = ?1")
	void updateDefaultAddressByUserId(Long id);
	
}
