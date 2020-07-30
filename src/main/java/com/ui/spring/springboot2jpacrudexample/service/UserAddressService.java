package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;

import com.ui.spring.springboot2jpacrudexample.model.UserAddress;

public interface UserAddressService {
	

	List<UserAddress> getUserAddress(Long userId);
	
	UserAddress createAddress(UserAddress userAddress);	

	UserAddress updateAddress(UserAddress userAddress);

	void deleteAddress(UserAddress userAddress);
	
	
}
