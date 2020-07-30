package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Inquiry;

public interface InquiryService {
	
	List<Inquiry> getAllInquirys();

	Optional<Inquiry> getInquiryById(Long CategoryId);

	Inquiry createInquiry(Inquiry inquiry);	
	
}
