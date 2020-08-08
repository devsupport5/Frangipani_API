package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.UserAddress;
import com.ui.spring.springboot2jpacrudexample.repository.UserAddressRepository;


@Service
public class UserServiceImpl implements UserAddressService{

	@Autowired
	private UserAddressRepository  userAddressRepository;
	
	@Override
	public List<UserAddress> getUserAddress(Long userId) {
		// TODO Auto-generated method stub
		return this.userAddressRepository.getUserAddress(userId);
	}

	@Override
	public UserAddress createAddress(UserAddress userAddress) {
		// TODO Auto-generated method stub
		return this.userAddressRepository.save(userAddress);
	}

	@Override
	public UserAddress updateAddress(UserAddress userAddress) {
		// TODO Auto-generated method stub
		return this.userAddressRepository.save(userAddress);
	}

	@Override
	public void deleteAddress(UserAddress userAddress) {
		// TODO Auto-generated method stub
		this.userAddressRepository.delete(userAddress);
		
	}

	@Override
	public Optional<UserAddress> getUserAddressById(Long id) {
		// TODO Auto-generated method stub
		return this.userAddressRepository.findById(id);
	}

	@Override
	public List<UserAddress> getGuestUserAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return this.userAddressRepository.getGuestUserAddress(emailAddress);
	}
}
