package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.RegisterUser;

public interface RegisterUserService {
	
	List<RegisterUser> getAllRegisterUser();

	Optional<RegisterUser> getRegisterUserById(Long CategoryId);

	RegisterUser createRegisterUser(RegisterUser registerUser);	

	RegisterUser updateRegisterUser(RegisterUser registerUser);

	void deleteRegisterUser(RegisterUser registerUser);
	
	RegisterUser checkRegisterUser(String userEmail,String password);
	
	RegisterUser checkUserName(String userName);
	
	RegisterUser checkEmailAddress(String userName);
	
	//List<Author> getActiveRegisterUser();
}
