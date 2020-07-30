package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Inquiry;
import com.ui.spring.springboot2jpacrudexample.repository.InquiryRepository;


@Service
public class InquiryServiceImpl implements InquiryService{

 
	@Autowired
	private InquiryRepository  inquiryRepository;
	
	@Override
	public List<Inquiry> getAllInquirys() {
		return this.inquiryRepository.findAll();
	}

	@Override
	public Optional<Inquiry> getInquiryById(Long AuthorId) {
		return this.inquiryRepository.findById(AuthorId);
	}

	@Override
	public Inquiry createInquiry(Inquiry inquiry) {
		return this.inquiryRepository.save(inquiry);
	}

	}
