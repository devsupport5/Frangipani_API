package com.ui.spring.springboot2jpacrudexample.service;

import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.AdminLogin;

public interface AdminService {

	Optional<AdminLogin> checkValidAdmin(String userName,String password);	

}
