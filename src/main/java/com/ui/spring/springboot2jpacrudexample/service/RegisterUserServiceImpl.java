package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.RegisterUser;
import com.ui.spring.springboot2jpacrudexample.repository.RegisterUserRepository;


@Service
public class RegisterUserServiceImpl implements RegisterUserService{

 
	@Autowired
	private RegisterUserRepository  registerUserRepository;
	
	@Override
	public List<RegisterUser> getAllRegisterUser() {
		return this.registerUserRepository.findAll();
	}

	@Override
	public Optional<RegisterUser> getRegisterUserById(Long AuthorId) {
		return this.registerUserRepository.findById(AuthorId);
	}

	@Override
	public RegisterUser createRegisterUser(RegisterUser registerUser) {
		return this.registerUserRepository.save(registerUser);
	}

	@Override
	public RegisterUser updateRegisterUser(RegisterUser registerUser) {
		return this.registerUserRepository.save(registerUser);
	}

	@Override
	public void deleteRegisterUser(RegisterUser registerUser) {
		this.registerUserRepository.delete(registerUser);
	}

	@Override
	public RegisterUser checkRegisterUser(String userEmail, String password) {
		// TODO Auto-generated method stub
		return this.registerUserRepository.checkRegisterUser(userEmail, password);
	}

	@Override
	public RegisterUser checkUserName(String userName) {
		// TODO Auto-generated method stub
		return this.registerUserRepository.checkUserName(userName);
	}

	@Override
	public RegisterUser checkEmailAddress(String userName) {
		// TODO Auto-generated method stub
		return this.registerUserRepository.checkEmailAddress(userName);
	}

	/*@Override
	public List<RegisterUser> getActiveRegisterUser() {
		// TODO Auto-generated method stub
		return this.registerUserRepository.getActiveRegisterUser();
	}*/

	 

}
