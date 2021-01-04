package com.ui.spring.springboot2jpacrudexample.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ui.spring.springboot2jpacrudexample.service.YearService;

@CrossOrigin
@RestController
@RequestMapping("/api/cat")
public class YearController {

	@Autowired
	YearService yearService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	/*@GetMapping("/categorys")
	public List<CategoryDTO> getAllcategorys() {
		List<Category> categories = categoryService.getAllCategorys();
		
		System.out.println("Size :::::::::::"+ categories.size());
		
		return categories.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}
	
	@GetMapping("/categorys/categoryList")
	public List<CategoryListViewDTO> getViewcategorys() {
		List<Category> categories = categoryService.getAllCategorys();
		
		System.out.println("Size :::::::::::"+ categories.size());
		
		return categories.stream()
        .map(this::convertToViewDto)
        .collect(Collectors.toList());
	}
	
	@GetMapping("/categorys/categoryActiveList")
	public List<CategoryListViewDTO> getcategoryActiveList() {
		List<Category> categories = categoryService.getActiveCategory();
		
		System.out.println("Size :::::::::::"+ categories.size());
		
		return categories.stream()
        .map(this::convertToViewDto)
        .collect(Collectors.toList());
	}

	@GetMapping("/categorys/{id}")
	public ResponseEntity<CategoryDTO> getEmployeeById(@PathVariable(value = "id") Long categoryId) {
		Category employee = categoryService.getCategoryById(categoryId).get();
		return ResponseEntity.ok().body(convertToDto(employee));
	}

	@PostMapping("/categorys")
	public Category createEmployee(@Valid @RequestBody CategoryDTO categoryDTO) {
		return categoryService.createCategory(convertToEntity(categoryDTO));
	}

	@PutMapping("/categorys/{id}")
	public ResponseEntity<Category> updateEmployee(@PathVariable(value = "id") Long categoryId,
			@Valid @RequestBody Category categoryDetails) throws ResourceNotFoundException {
		
		Category category = categoryService.getCategoryById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

		category.setId(categoryDetails.getId());
		category.setCategoryName(categoryDetails.getCategoryName());
		category.setDescription(categoryDetails.getDescription());
		category.setIsActive(categoryDetails.getIsActive());
		final Category updatedCategory = categoryService.updateCategory(categoryDetails);
		return ResponseEntity.ok(updatedCategory);
	}
	

	@DeleteMapping("/categorys/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Category category = categoryService.getCategoryById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("category not found for this id :: " + employeeId));

		categoryService.deleteCategory(category);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public CategoryDTO convertToDto(Category category) {
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
	
	public CategoryListViewDTO convertToViewDto(Category category) {
		CategoryListViewDTO categoryDTO = modelMapper.map(category, CategoryListViewDTO.class);
		return categoryDTO;
	}
	
	public Category  convertToEntity(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}
	
	@GetMapping("/categorys/allsubcategorys")
	public List<CategoryDTO> getAllSubCategorys() {
		List<Category> categories = categoryService.getAllSubCategorys();
		return categories.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}
	
	@GetMapping("/subcategorys/{id}")
	public List<CategoryDTO> getSubCategorys(@PathVariable(value = "id") Integer categoryId) {
		List<Category> categories = categoryService.getSubCategorys(categoryId);
		return categories.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}*/
}
