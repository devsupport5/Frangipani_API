package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.UserDetail;

public interface UserService {
	
	List<UserDetail> getAllUsers();
	
	Optional<UserDetail> getUserById(Long userId);
	
	UserDetail checkValidUser(String userEmail,String password);

	UserDetail createUser(UserDetail User);	

	UserDetail updateUser(UserDetail User);

	void deleteUser(UserDetail User);

	UserDetail checkValidEmail(String userEmail);
	
}
