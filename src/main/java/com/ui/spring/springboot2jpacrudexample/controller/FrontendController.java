package com.ui.spring.springboot2jpacrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ui.spring.springboot2jpacrudexample.model.Product;
import com.ui.spring.springboot2jpacrudexample.repository.AuthorRepository;
import com.ui.spring.springboot2jpacrudexample.repository.CategoryRepository;
import com.ui.spring.springboot2jpacrudexample.repository.ProductRepository;
import com.ui.spring.springboot2jpacrudexample.service.AuthorService;
import com.ui.spring.springboot2jpacrudexample.service.CategoryService;

@Controller
public class FrontendController {

	/*@Autowired
	FrontendService frontendService;*/
	
	
	
	@Autowired
	private CategoryService  categoryRepository;
	
	@Autowired
	private ProductRepository  productRepository;
	
	@Autowired
	private AuthorService  authorService;
	
	
	
	@RequestMapping("/")
	public String  home(Model model) {
		
		model.addAttribute("categories",categoryRepository.getActiveCategory());
		model.addAttribute("featuredProduct",productRepository.getFeaturedProduct());
		
		System.out.println("size---------------->>>"+categoryRepository.getActiveCategory().size());
		
		return "index";
	}
	 
	
	@RequestMapping("/category")
	public String  getCategory(Model model) {
		
		model.addAttribute("categories",categoryRepository.getActiveCategory());
		
		System.out.println("size---------------->>>"+categoryRepository.getActiveCategory().size());
		
		return "category";
	}
 
	@RequestMapping("/productList/{categoryId}/{categoryName}")
	public String  productList(@PathVariable("categoryId") int categoryId,@PathVariable("categoryName") String categoryName,Model model) {
		
		System.out.println("This is call-------------------");
			model.addAttribute("categoryName",categoryName);
			model.addAttribute("productList",productRepository.getProductByCategory(Integer.parseInt(categoryId+"")));
		return "product_list";
	}
	
	@RequestMapping("/featured/product")
	public String  featured(Model model) {
			model.addAttribute("productList",productRepository.getFeaturedProduct());
		return "featured_product_list";
	}
	 
	@RequestMapping("/product/{productId}")
	public String  product(@PathVariable("productId") int categoryId,Model model) {
		
			Product product = productRepository.getProductById(Long.parseLong(categoryId+""));
		
			if(product!=null){
					model.addAttribute("author",authorService.getAuthorById(Long.parseLong(product.getAuthorId()+"")).get());
					model.addAttribute("category",categoryRepository.getCategoryById(Long.parseLong(product.getCategoryId()+"")).get());
				}
				
			model.addAttribute("product",product);
		return "books_details";
	}
	
	
	 @RequestMapping("/authors")
     public String  getAllauthorss(Model model) {
         
         model.addAttribute("authors",authorService.getAllAuthors());
         
    System.out.println("size---------------->>>"+authorService.getAllAuthors().size());
         
         return "authors";
     }
    
    @RequestMapping("/contact")
    public String  getAllcontact(Model model) {
     
      System.out.println("-------contact--------->>>");
        return "contact-us";
    }
    @RequestMapping("/book")
    public String  getAllbookes(Model model) {
        
       
        
        return "books";
    }
    
    @RequestMapping("/about-frangipani-books")
    public String  Aboutbookes(Model model) {
      System.out.println("-------about-frangipani-books--------->>>");
       

        return "about-frangipani-books";
    }
    
    @RequestMapping("/my_account")
    public String  myaccount(Model model) {
        
      System.out.println("-------my-account--------->>>");
      
        return "my_account";
    }
    
    @RequestMapping("/refund_cancellation")
    public String  refund_cancellation(Model model) {
        
      System.out.println("-------refund-&-cancellation------->>>");
      
        return "refund_cancellation";
    }
    
    @RequestMapping("/terms_conditions")
    public String  terms_conditions(Model model) {
        
      System.out.println("-------terms-conditions------->>>");
      
        return "terms_conditions";
    }
    @RequestMapping("/privacy_policy")
    public String  privacy_policy(Model model) {
        
      System.out.println("-------privacy-policy------->>>");
      
        return "privacy_policy";
    }
    
    @RequestMapping("/cart")
    public String  cart(Model model) {
        
      System.out.println("-------privacy-policy------->>>");
      
        return "privacy_policy";
    }
	
}
