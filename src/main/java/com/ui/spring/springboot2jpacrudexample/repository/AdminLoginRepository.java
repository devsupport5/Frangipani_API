package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.AdminLogin;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, Long>{

	@Query("SELECT u FROM AdminLogin u WHERE u.userName = ?1 and u.password = ?2")
	Optional<AdminLogin> checkValidAdmin(String userName,String password);
	
}
