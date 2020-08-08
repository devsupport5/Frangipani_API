package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ui.spring.springboot2jpacrudexample.beans.ProductDTO;
import com.ui.spring.springboot2jpacrudexample.model.OrderItem;
import com.ui.spring.springboot2jpacrudexample.model.Product;
import com.ui.spring.springboot2jpacrudexample.model.RegisterUser;
import com.ui.spring.springboot2jpacrudexample.model.Slider;
import com.ui.spring.springboot2jpacrudexample.model.UserAddress;
import com.ui.spring.springboot2jpacrudexample.repository.ProductRepository;
import com.ui.spring.springboot2jpacrudexample.service.AuthorService;
import com.ui.spring.springboot2jpacrudexample.service.CategoryService;
import com.ui.spring.springboot2jpacrudexample.service.CurrencyService;
import com.ui.spring.springboot2jpacrudexample.service.ProductService;
import com.ui.spring.springboot2jpacrudexample.service.RegisterUserService;
import com.ui.spring.springboot2jpacrudexample.service.SliderService;
import com.ui.spring.springboot2jpacrudexample.service.UserAddressService;

@Controller
public class FrontendController {

	/*@Autowired
	FrontendService frontendService;*/
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	RegisterUserService registerUserService;
	
	@Autowired
	private CategoryService  categoryRepository;
	
	@Autowired
	CurrencyService currencyService;
	
	@Autowired
	private ProductRepository  productRepository;
	
	@Autowired
	private AuthorService  authorService;
	
	@Autowired
	private ProductService  productService;
	
	@Autowired
	private SliderService  sliderService;

	/*@Autowired
	private ProductListRepository productListRepository;;
	*/
	@Autowired
	private UserAddressService userAddressService;
	
	
	@RequestMapping("/")
	public String  home(Model model,HttpSession session) {
		
		System.out.println(currencyService.getDefaultCurrency().getCurrencySymbol());
		
		session.setAttribute("currencySymbol",currencyService.getDefaultCurrency().getCurrencySymbol());
		
		model.addAttribute("sliderList", sliderService.getActiveSliders());
		model.addAttribute("authorList", authorService.getActiveAuthors());
		
		model.addAttribute("categories",categoryRepository.getActiveCategory());
		
		List<Product> products = productRepository.getFeaturedProduct();
		
		for (int i = 0; i < products.size(); i++) {
			products.get(i).setCurrency(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).get());
		}
		model.addAttribute("featuredProduct",products.stream().map(this::convertToDto).collect(Collectors.toList()));
		
		return "index";
	}
	 
	/*@RequestMapping("/getProductListData" )
	@ResponseBody public List<ProductList>  getProductListData() {
		return productListRepository.getProductLists();
	}*/
	
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
			
			List<Product> products = productRepository.getProductByCategory(Long.parseLong(categoryId+""));
			for (int i = 0; i < products.size(); i++) {
				products.get(i).setCurrency(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).get());
			}
			model.addAttribute("productList",products.stream().map(this::convertToDto).collect(Collectors.toList()));
		return "product_list";
	}
	
	@RequestMapping("/featured/product")
	public String  featured(Model model) {
		
		List<Product> products = productRepository.getFeaturedProduct();
		for (int i = 0; i < products.size(); i++) {
			products.get(i).setCurrency(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).get());
		}
		model.addAttribute("productList",products.stream().map(this::convertToDto).collect(Collectors.toList()));
			
		return "featured_product_list";
	}
	 
	@RequestMapping("/product/{productId}")
	public String  product(@PathVariable("productId") int categoryId,Model model) {
		
			Product product = productRepository.getProductById(Long.parseLong(categoryId+""));
		
			if(product!=null){
				
				System.out.println(product.getAuthorId() +"-----------------");
					product.setCurrency(currencyService.getCurrencyById(Long.parseLong(product.getCurrencyId()+"")).get());
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
        
    	
    	List<Product> products = productService.getAllProducts();
		
		for (int i = 0; i < products.size(); i++) {
			products.get(i).setCurrency(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).get());
		}
		model.addAttribute("products",products.stream().map(this::convertToDto).collect(Collectors.toList()));
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
    	
    	long userId = 0;
    	if(session.getAttribute("userId")!=null)
    		userId = Long.parseLong(session.getAttribute("userId")+"");
    	else
    		userId = 0;
    	
    	userAddress.setUserId(Integer.parseInt(userId +""));
    	userAddressService.createAddress(userAddress);
    	 
    	return userAddressService.getUserAddress(userId);
    }
    
    @RequestMapping("/getUserAddress" )
    @ResponseBody  public List<UserAddress> getUserAddress(HttpSession session) {
    	
    	if(session.getAttribute("userId")!=null)
    		return userAddressService.getUserAddress(Long.parseLong(session.getAttribute("userId")+""));
    	else
    		return null;
    }
    
    @RequestMapping("/getGuestUserAddress" )
    @ResponseBody  public List<UserAddress> getGuestUserAddress(HttpSession session,String guestEmailAddress) {
		return userAddressService.getGuestUserAddress(guestEmailAddress);
    	
    }
    
    @RequestMapping("/getAddressById" )
    @ResponseBody  public UserAddress getAddressById(HttpServletRequest request) {
    	return userAddressService.getUserAddressById(Long.parseLong(request.getParameter("addressId")+"")).get();
    }
    
    @RequestMapping("/viewCart" )
    public String  viewCart(HttpSession session,Model model) {
    	  
    /*if(session.getAttribute("orderItem")!=null) {	
		List<OrderItem> items = (List<OrderItem>) session.getAttribute("orderItem");
		if(items.size()>0)
			model.addAttribute("cartList", items);
		else
			model.addAttribute("error", "Cart is empty");
		}else
			model.addAttribute("error", "Cart is empty");*/ 
    
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
    	orderItem.setCurrencySymbol(currencyService.getCurrencyById(Long.parseLong(product.getCurrencyId()+"")).get().getCurrencySymbol());
	
    	
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
    @ResponseBody public String  removeToCart(OrderItem orderItem,HttpSession session) {
		
		List<OrderItem> items = (List<OrderItem>) session.getAttribute("orderItem");
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getOrderId()==orderItem.getOrderId()) {
				items.remove(i);
			}
		} 
		session.setAttribute("orderItem",items);
		
		return "";
	}
    
	@RequestMapping("/removeToCartButton" )
    @ResponseBody public String  removeToCartButton(OrderItem orderItem,HttpSession session) {
		
		List<OrderItem> items = (List<OrderItem>) session.getAttribute("orderItem");
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getOrderId()==orderItem.getOrderId()) {
				 
				if(items.get(i).getQty() == 1) {
					items.remove(i);	
				}else {
					items.get(i).setQty(items.get(i).getQty()-1);
				}
				
				
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
    
    @RequestMapping("/checkoutGuest" )
    public String checkoutGuest(HttpSession session,HttpServletRequest request,Model model) {
    	 
    	model.addAttribute("guestMobileNumber",request.getParameter("guestMobileNumber"));
    	model.addAttribute("guestEmailAddress",request.getParameter("guestEmailAddress"));
  	  	 
  	  	return "checkout_guest";
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
    public String  manage_address(HttpSession session,Model model) {
        
      System.out.println("-------manage_address------->>>");
      Integer userId = 0;
  		if(session.getAttribute("userId")!=null)    	
  			userId = Integer.parseInt(session.getAttribute("userId")+"");
  		
      
      
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

    public ProductDTO convertToDto(Product Product) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ProductDTO ProductDTO = modelMapper.map(Product, ProductDTO.class);
		return ProductDTO;
	}
    
}
