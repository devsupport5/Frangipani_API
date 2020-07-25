package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ui.spring.springboot2jpacrudexample.beans.SliderDTO;
import com.ui.spring.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.ui.spring.springboot2jpacrudexample.model.Slider;
import com.ui.spring.springboot2jpacrudexample.service.SliderService;

@CrossOrigin
@RestController
@RequestMapping("/api/slider")
public class SliderController {

	@Autowired
	SliderService SliderService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/sliders")
	public List<SliderDTO> getAllSliders() {
		List<Slider> sliders = SliderService.getAllSliders();
		return sliders.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/sliders/{id}")
	public ResponseEntity<SliderDTO> getSliderById(@PathVariable(value = "id") Long sliderDTO) {
		Slider slider = SliderService.getSliderById(sliderDTO).get();
		return ResponseEntity.ok().body(convertToDto(slider));
	}

	@PostMapping("/sliders")
	public Slider createSlider(@Valid @RequestBody SliderDTO sliderDTO) {
		return SliderService.createSlider(convertToEntity(sliderDTO));
	}

	@PutMapping("/sliders/{id}")
	public ResponseEntity<Slider> updateSlider(@PathVariable(value = "id") Long sliderId,
			@Valid @RequestBody Slider SliderDetails) throws ResourceNotFoundException {
		Slider Slider = SliderService.getSliderById(sliderId)
				.orElseThrow(() -> new ResourceNotFoundException("Slider not found for this id :: " + sliderId));

		Slider.setId(SliderDetails.getId());
		Slider.setSliderName(SliderDetails.getSliderName());
		Slider.setDescription(SliderDetails.getDescription());
		final Slider updatedSlider = SliderService.updateSlider(SliderDetails);
		return ResponseEntity.ok(updatedSlider);
	}

	@DeleteMapping("/sliders/{id}")
	public Map<String, Boolean> deleteSlider(@PathVariable(value = "id") Long sliderId)
			throws ResourceNotFoundException {
		Slider Slider = SliderService.getSliderById(sliderId)
				.orElseThrow(() -> new ResourceNotFoundException("Slider not found for this id :: " + sliderId));

		SliderService.deleteSlider(Slider);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public SliderDTO convertToDto(Slider slider) {
		SliderDTO SliderDTO = modelMapper.map(slider, SliderDTO.class);
		return SliderDTO;
	}
	
	public Slider  convertToEntity(SliderDTO sliderDTO) {
		Slider Slider = modelMapper.map(sliderDTO, Slider.class);
		return Slider;
	}
	
	 
}
