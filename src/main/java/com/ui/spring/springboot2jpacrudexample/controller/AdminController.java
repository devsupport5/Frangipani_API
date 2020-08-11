package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ui.spring.springboot2jpacrudexample.model.AdminLogin;
import com.ui.spring.springboot2jpacrudexample.model.Product;
import com.ui.spring.springboot2jpacrudexample.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PutMapping("/checkAdmin")
	public boolean checkAdmin(@Valid @RequestBody AdminLogin adminLogin) {
		System.out.println(adminLogin.getUserName() +"---"+adminLogin.getPassword());
		
		Optional<AdminLogin> authors = adminService.checkValidAdmin(adminLogin.getUserName(), adminLogin.getPassword());
		if(authors.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	 
	
	 
}
