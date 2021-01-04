package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Year;
import com.ui.spring.springboot2jpacrudexample.repository.YearRepository;


@Service
public class YearServiceImpl implements YearService{

 
	@Autowired
	private YearRepository  yearRepository;
	
	@Override
	public List<Year> getAllYears() {
		return this.yearRepository.findAll();
	}

	@Override
	public Optional<Year> getYearById(Long yearId) {
		return this.yearRepository.findById(yearId);
	}

	@Override
	public Year createYear(Year year) {
		return this.yearRepository.save(year);
	}

	@Override
	public Year updateYear(Year year) {
		return this.yearRepository.save(year);
	}

	@Override
	public void deleteYear(Year year) {
		this.yearRepository.delete(year);
	}

	@Override
	public List<Year> getActiveYear() {
		// TODO Auto-generated method stub
		return this.yearRepository.getActiveYear();
	}

	 

}
