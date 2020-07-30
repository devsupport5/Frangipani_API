package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ui.spring.springboot2jpacrudexample.beans.UserAddressDTO;
import com.ui.spring.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.ui.spring.springboot2jpacrudexample.model.UserAddress;
import com.ui.spring.springboot2jpacrudexample.service.UserAddressService;

@CrossOrigin
@RestController
@RequestMapping("/api/useraddres")
public class UserAddressController {
	
	@Autowired
	private UserAddressService userAddressService;

	@Autowired
    private ModelMapper modelMapper;
	
	
	@GetMapping("/useraddress")
	public List<UserAddressDTO> getAllUserDetails(@PathVariable(value = "id") Long userId) {
		List<UserAddress> userDetails = userAddressService.getUserAddress(userId);
		
		System.out.println("Size :::::::::::"+ userDetails.size());
		
		return userDetails.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}


	@PostMapping("/useraddress")
	public UserAddress createUserDetail(@Valid @RequestBody UserAddressDTO UserAddressDTO) {
		return userAddressService.createAddress(convertToEntity(UserAddressDTO));
	}
	
	 

	@PutMapping("/useraddress/{id}")
	public ResponseEntity<UserAddress> updateUserDetail(@PathVariable(value = "id") Long addressId,
			@Valid @RequestBody UserAddress employeeDetails) throws ResourceNotFoundException {
	/*	UserAddress employee = userAddressService.updateAddress(employeeDetails)
				.orElseThrow(() -> new ResourceNotFoundException("UserDetail not found for this id :: " + addressId));

		employee.setUserEmail(employeeDetails.getUserEmail());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final UserDetail updatedUserDetail = userAddressService.updateUser(employeeDetails);
		return ResponseEntity.ok(updatedUserDetail);*/
		return null;
	}

	/*@DeleteMapping("/useraddress/{id}")
	public Map<String, Boolean> deleteUserDetail(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		UserAddress employee = ((Object) userAddressService.getUserAddress(userId))
				.orElseThrow(() -> new ResourceNotFoundException("UserDetail not found for this id :: " + userId));

		userAddressService.deleteAddress(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
	
	public UserAddressDTO convertToDto(UserAddress userDetail) {
		UserAddressDTO userDTO = modelMapper.map(userDetail, UserAddressDTO.class);
		return userDTO;
	}
	
	public UserAddress convertToEntity(UserAddressDTO userDTO) {
		UserAddress userDetail = modelMapper.map(userDTO, UserAddress.class);
		return userDetail;
	}
}
