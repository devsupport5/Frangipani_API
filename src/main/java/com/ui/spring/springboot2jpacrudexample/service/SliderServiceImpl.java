package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Slider;
import com.ui.spring.springboot2jpacrudexample.repository.SliderRepository;


@Service
public class SliderServiceImpl implements SliderService{

 
	@Autowired
	private SliderRepository  SliderRepository;
	
	@Override
	public List<Slider> getAllSliders() {
		return this.SliderRepository.findAll();
	}

	@Override
	public Optional<Slider> getSliderById(Long sliderId) {
		return this.SliderRepository.findById(sliderId);
	}

	@Override
	public Slider createSlider(Slider slider) {
		return this.SliderRepository.save(slider);
	}

	@Override
	public Slider updateSlider(Slider slider) {
		return this.SliderRepository.save(slider);
	}

	@Override
	public void deleteSlider(Slider slider) {
		this.SliderRepository.delete(slider);
	}

	 

}
