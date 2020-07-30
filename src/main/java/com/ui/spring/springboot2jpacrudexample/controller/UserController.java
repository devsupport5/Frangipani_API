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

import com.ui.spring.springboot2jpacrudexample.beans.UserDTO;
import com.ui.spring.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.ui.spring.springboot2jpacrudexample.model.UserDetail;
import com.ui.spring.springboot2jpacrudexample.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
    private ModelMapper modelMapper;
	
	
	@GetMapping("/users")
	public List<UserDTO> getAllUserDetails() {
		List<UserDetail> userDetails = userService.getAllUsers();
		
		System.out.println("Size :::::::::::"+ userDetails.size());
		
		return userDetails.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getUserDetailById(@PathVariable(value = "id") Long employeeId) {
		UserDetail employee = userService.getUserById(employeeId).get();
		return ResponseEntity.ok().body(convertToDto(employee));
	}

	@PostMapping("/users")
	public UserDetail createUserDetail(@Valid @RequestBody UserDTO UserDTO) {
		return userService.createUser(convertToEntity(UserDTO));
	}
	
	@PostMapping("/checkUserValid/{userEmail}/{password}")
	public UserDetail checkUserValid(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "password") String password) {
		return userService.checkValidUser(userEmail, password);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserDetail> updateUserDetail(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody UserDetail employeeDetails) throws ResourceNotFoundException {
		UserDetail employee = userService.getUserById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("UserDetail not found for this id :: " + employeeId));

		employee.setUserEmail(employeeDetails.getUserEmail());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final UserDetail updatedUserDetail = userService.updateUser(employeeDetails);
		return ResponseEntity.ok(updatedUserDetail);
	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUserDetail(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		UserDetail employee = userService.getUserById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("UserDetail not found for this id :: " + employeeId));

		userService.deleteUser(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public UserDTO convertToDto(UserDetail userDetail) {
		UserDTO userDTO = modelMapper.map(userDetail, UserDTO.class);
		return userDTO;
	}
	
	public UserDetail convertToEntity(UserDTO userDTO) {
		UserDetail userDetail = modelMapper.map(userDTO, UserDetail.class);
		return userDetail;
	}
}
