package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Year;

public interface YearService {
	
	List<Year> getAllYears();

	Optional<Year> getYearById(Long YearId);

	Year createYear(Year Year);	

	Year updateYear(Year Year);

	void deleteYear(Year Year);
	
	List<Year> getActiveYear();
	

}
