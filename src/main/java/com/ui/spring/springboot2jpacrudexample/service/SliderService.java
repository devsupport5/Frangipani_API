package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Slider;

public interface SliderService {
	
	List<Slider> getAllSliders();

	Optional<Slider> getSliderById(Long sliderId);

	Slider createSlider(Slider slider);	

	Slider updateSlider(Slider slider);

	void deleteSlider(Slider slider);
	
	List<Slider> getActiveSliders();
}
