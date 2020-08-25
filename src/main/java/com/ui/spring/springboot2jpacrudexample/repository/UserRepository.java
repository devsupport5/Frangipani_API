package com.ui.spring.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long>{

	
	@Query("SELECT u FROM UserDetail u WHERE u.userEmail = ?1 and u.password = ?2")
	UserDetail checkValidUser(String userEmail,String password);
	
	@Query("SELECT u FROM UserDetail u WHERE u.userEmail = ?1")
	UserDetail checkValidEmail(String userEmail);
	
}
