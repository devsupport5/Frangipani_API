package com.ui.spring.springboot2jpacrudexample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.AdminLogin;
import com.ui.spring.springboot2jpacrudexample.repository.AdminLoginRepository;


@Service
public class AdminServiceImpl implements AdminService{

 
	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	@Override
	public Optional<AdminLogin> checkValidAdmin(String userName,String password) {
		return this.adminLoginRepository.checkValidAdmin(userName, password);
	}

}
