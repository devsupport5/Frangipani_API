package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ui.spring.springboot2jpacrudexample.model.OrderItem;
import com.ui.spring.springboot2jpacrudexample.model.Product;
import com.ui.spring.springboot2jpacrudexample.model.RegisterUser;
import com.ui.spring.springboot2jpacrudexample.model.Slider;
import com.ui.spring.springboot2jpacrudexample.model.UserAddress;
import com.ui.spring.springboot2jpacrudexample.repository.ProductRepository;
import com.ui.spring.springboot2jpacrudexample.service.AuthorService;
import com.ui.spring.springboot2jpacrudexample.service.CategoryService;
import com.ui.spring.springboot2jpacrudexample.service.ProductService;
import com.ui.spring.springboot2jpacrudexample.service.RegisterUserService;
import com.ui.spring.springboot2jpacrudexample.service.SliderService;
import com.ui.spring.springboot2jpacrudexample.service.UserAddressService;

@Controller
public class FrontendController {

	/*@Autowired
	FrontendService frontendService;*/
	
	@Autowired
	RegisterUserService registerUserService;
	
	@Autowired
	private CategoryService  categoryRepository;
	
	@Autowired
	private ProductRepository  productRepository;
	
	@Autowired
	private AuthorService  authorService;
	
	@Autowired
	private ProductService  productService;
	
	@Autowired
	private SliderService  sliderService;
	
	@Autowired
	private UserAddressService userAddressService;
	
	
	@RequestMapping("/")
	public String  home(Model model) {
		
		model.addAttribute("sliderList", sliderService.getActiveSliders());
		model.addAttribute("authorList", authorService.getActiveAuthors());
		
		model.addAttribute("categories",categoryRepository.getActiveCategory());
		model.addAttribute("featuredProduct",productRepository.getFeaturedProduct());
		return "index";
	}
	 
	@RequestMapping("/getSliderList" )
	@ResponseBody public List<Slider>  getSliderList() {
		return sliderService.getAllSliders();
	}
	
	
	@RequestMapping("/category")
	public String  getCategory(Model model) {
		
		model.addAttribute("categories",categoryRepository.getActiveCategory());
		
		return "category";
	}
 
	@RequestMapping("/productList/{categoryId}/{categoryName}")
	public String  productList(@PathVariable("categoryId") int categoryId,@PathVariable("categoryName") String categoryName,Model model) {
		
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
				
				System.out.println(product.getAuthorId() +"-----------------");
				
					model.addAttribute("author",authorService.getAuthorById(Long.parseLong(product.getAuthorId()+"")).get());
					model.addAttribute("category",categoryRepository.getCategoryById(Long.parseLong(product.getCategoryId()+"")).get());
				}
				
			model.addAttribute("product",product);
		return "books_details";
	}
	
	
	 @RequestMapping("/authors")
     public String  getAllauthorss(Model model) {
         
         model.addAttribute("authors",authorService.getAllAuthors());
         
         
         return "authors";
     }
    
    @RequestMapping("/contact")
    public String  getAllcontact(Model model) {
     
        return "contact-us";
    }
    @RequestMapping("/book")
    public String  getAllbookes(Model model) {
        
    	model.addAttribute("products",productService.getAllProducts());
        
        return "books";
    }
    
    @RequestMapping("/about-frangipani-books")
    public String  Aboutbookes(Model model) {
        return "about-frangipani-books";
    }
    
    @RequestMapping("/my_account" )
    public String  myaccount(HttpSession session) {
      
    	if(session.getAttribute("userId")==null) {
    		return "my_account";	
    	}else
    		return "redirect:/";
        
    }
    
    @RequestMapping("/addNewAddress" )
    @ResponseBody  public List<UserAddress> addNewAddress(UserAddress userAddress,HttpSession session) {
    	
    	userAddress.setUserId(Integer.parseInt(session.getAttribute("userId")+""));
    	userAddressService.createAddress(userAddress);
    	
    	return userAddressService.getUserAddress(Long.parseLong(session.getAttribute("userId")+""));
    }
    
    @RequestMapping("/getUserAddress" )
    @ResponseBody  public List<UserAddress> getUserAddress(HttpSession session) {
    	
    	if(session.getAttribute("userId")!=null)
    		return userAddressService.getUserAddress(Long.parseLong(session.getAttribute("userId")+""));
    	else
    		return null;
    }
    
    @RequestMapping("/viewCart" )
    public String  viewCart(HttpSession session,Model model) {
    	  
    if(session.getAttribute("orderItem")!=null) {	
		List<OrderItem> items = (List<OrderItem>) session.getAttribute("orderItem");
		if(items.size()>0)
			model.addAttribute("cartList", items);
		else
			model.addAttribute("error", "Cart is empty");
		}else
			model.addAttribute("error", "Cart is empty");
    
    		return "cart";
    }
    
	@RequestMapping("/addToCart" )
    @ResponseBody public Integer  addToCart(OrderItem orderItem,HttpSession session) {
      
    	System.out.println("-------------------This is call-------------------------");
    	
    	Integer userId = 0;
    	if(session.getAttribute("userId")!=null)    	
    		userId = Integer.parseInt(session.getAttribute("userId")+"");
    	
    	
    	Product product =  productService.getProductById(orderItem.getOrderId()).get();
    	
    	orderItem.setAuthorName(authorService.getAuthorById(product.getAuthorId()).get().getAuthorName());
    	orderItem.setBookTitle(product.getBookTitle());
    	orderItem.setPrice(product.getOriginalPrice());
    	orderItem.setUserId(userId);
    	orderItem.setCategoryName(categoryRepository.getCategoryById(product.getCategoryId()).get().getCategoryName());
    	
    	
    	List<OrderItem> items = new ArrayList<OrderItem>();
    	if(session.getAttribute("orderItem")==null) {
    		items.add(orderItem);
    		session.setAttribute("orderItem",items);
    		
    	}else {
    		items = (List<OrderItem>) session.getAttribute("orderItem");
    		
    		boolean checkStatus = true;
    		for (int i = 0; i < items.size(); i++) {
    			
    			System.out.println(items.get(i).getOrderId() +"---"+orderItem.getOrderId());
    			
    			if(items.get(i).getOrderId()==orderItem.getOrderId()) {
    				items.get(i).setQty(items.get(i).getQty() + orderItem.getQty());
    				checkStatus = false;
    			}
			}
    		
    		if(checkStatus) {
				orderItem.setUserId(userId);
				items.add(orderItem);	
			}
    		
    		session.setAttribute("orderItem",items);
    		
    	}
    	
    	
    	for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getOrderId() +"---"+items.get(i).getPrice() +"-------"+items.get(i).getQty());
		}
    	
    	
    	return items.size();       
    }
	
	@RequestMapping("/getCart")
    @ResponseBody public List<OrderItem>  getCart(OrderItem orderItem,HttpSession session) {
		 return (List<OrderItem>) session.getAttribute("orderItem");
	}
	
	
	@RequestMapping("/removeToCart" )
    public String  removeToCart(OrderItem orderItem,HttpSession session) {
		
		List<OrderItem> items = (List<OrderItem>) session.getAttribute("orderItem");
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getOrderId()==orderItem.getOrderId()) {
				items.remove(i);
			}
		}
		session.setAttribute("orderItem",items);
		
		return "";
	}
    
    
    @RequestMapping("/checkValidUser" )
    @ResponseBody public boolean  checkValidUser(HttpSession session,RegisterUser registerUser,HttpServletRequest request) {
      RegisterUser user = registerUserService.checkRegisterUser(request.getParameter("userEmailId"), request.getParameter("userPassword"));
      
      
      System.out.println(request.getParameter("userEmailId") +"-----------"+request.getParameter("password"));
      
      if(user!=null) {
    	  session.setAttribute("userId",user.getId());
    	  session.setAttribute("userName",user.getYourName());
    	  return true;
      }else {
    	  return false;
      }
    }
     
    @RequestMapping("/registration" )
    @ResponseBody public void  registration(HttpSession session,RegisterUser registerUser,HttpServletRequest request) {
      RegisterUser user = registerUserService.createRegisterUser(registerUser);
      
      if(user!=null) {
    	  session.setAttribute("userId",user.getId());
    	  session.setAttribute("userName",user.getYourName()); 
      }
    }
    
    @RequestMapping("/checkout")
    public String checkout(HttpSession session) {
    	 
  	  	 
  	  	return "checkout";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.setAttribute("userId",null);
  	  	session.setAttribute("userName",null);
  	  	 
  	  	return "redirect:/";
    }
    
    
    @RequestMapping("/refund_cancellation")
    public String  refund_cancellation(Model model) {
        
      System.out.println("-------refund-&-cancellation------->>>");
      
        return "refund_cancellation";
    }
    
    @RequestMapping("/my_order")
    public String  my_order(HttpSession session) {
        
      System.out.println("-------my-orders------->>>");
      int userId =  (int) session.getAttribute("userId");
      
        return "my_orders";
    }
    
    @RequestMapping("/manage_address")
    public String  manage_address(Model model) {
        
      System.out.println("-------manage_address------->>>");
       
        return "manage_addresses";
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
