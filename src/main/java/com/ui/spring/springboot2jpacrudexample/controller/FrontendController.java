package com.ui.spring.springboot2jpacrudexample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ui.spring.springboot2jpacrudexample.service.CategoryService;
import com.ui.spring.springboot2jpacrudexample.service.ProductService;

@Controller
public class FrontendController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService ProductService;
	
	@RequestMapping("/")
	public String  home(Model model) {
		
		model.addAttribute("categories",categoryService.getAllCategorys());
		
		System.out.println("size---------------->>>"+categoryService.getAllCategorys().size());
		
		return "index";
	}
	 
	
	@RequestMapping("/books")
	public String  getAllauthors(Model model) {
		
		model.addAttribute("categories",categoryService.getAllCategorys());
		
		System.out.println("size---------------->>>"+categoryService.getAllCategorys().size());
		
		return "books_by_category";
	}
 
	@RequestMapping("/productList/{categoryId}")
	public String  productList(@PathVariable("categoryId") int categoryId,Model model) {
		
		System.out.println("This is call-------------------");
		
			model.addAttribute("productList",ProductService.getProductByCategory(Integer.parseInt(categoryId+"")));
		return "bio_memoirs";
	}
	
	 
}
