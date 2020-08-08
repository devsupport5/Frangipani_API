package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.UserAddress;

public interface UserAddressService {
	

	List<UserAddress> getUserAddress(Long userId);
	
	List<UserAddress> getGuestUserAddress(String emailAddress);
	
	UserAddress createAddress(UserAddress userAddress);	

	UserAddress updateAddress(UserAddress userAddress);

	void deleteAddress(UserAddress userAddress);
	
	Optional<UserAddress> getUserAddressById(Long sliderId);
	
	
}
