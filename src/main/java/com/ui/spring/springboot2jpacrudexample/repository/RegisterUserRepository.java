package com.ui.spring.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.RegisterUser;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long>{
	
	@Query("SELECT u FROM RegisterUser u WHERE u.userName = ?1 and u.password = ?2")
	RegisterUser checkRegisterUser(String userEmail, String password);;
	
	@Query("SELECT u FROM RegisterUser u WHERE u.userName = ?1")
	RegisterUser checkUserName(String userName);
	
	@Query("SELECT u FROM RegisterUser u WHERE u.userEmail = ?1")
	RegisterUser checkEmailAddress(String userEmail);
}
