package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Slider;

@Repository
public interface SliderRepository extends JpaRepository<Slider, Long>{
	 
	@Query("SELECT u FROM Slider u WHERE u.isActive = 0")
	List<Slider> getActiveSliders(); 
	
}
