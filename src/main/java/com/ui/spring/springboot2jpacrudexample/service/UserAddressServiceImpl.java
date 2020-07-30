package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.UserDetail;
import com.ui.spring.springboot2jpacrudexample.repository.UserRepository;


@Service
public class UserAddressServiceImpl implements UserService{

 
	@Autowired
	private UserRepository  userRepository;
	
	@Override
	public List<UserDetail> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public UserDetail createUser(UserDetail userDetail) {
		return this.userRepository.save(userDetail);
	}

	@Override
	public UserDetail updateUser(UserDetail userDetail) {
		return this.userRepository.save(userDetail);
	}

	@Override
	public void deleteUser(UserDetail userDetail) {
		this.userRepository.delete(userDetail);
	}

	@Override
	public Optional<UserDetail> getUserById(Long userId) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(userId);
	}

	@Override
	public UserDetail checkValidUser(String userEmail, String password) {
		// TODO Auto-generated method stub
		return this.userRepository.checkValidUser(userEmail, password);
	}

}
