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

import com.ui.spring.springboot2jpacrudexample.MailConfiguration;
import com.ui.spring.springboot2jpacrudexample.beans.ProductDTO;
import com.ui.spring.springboot2jpacrudexample.model.Inquiry;
import com.ui.spring.springboot2jpacrudexample.model.Order;
import com.ui.spring.springboot2jpacrudexample.model.OrderItem;
import com.ui.spring.springboot2jpacrudexample.model.OrderItems;
import com.ui.spring.springboot2jpacrudexample.model.Product;
import com.ui.spring.springboot2jpacrudexample.model.RegisterUser;
import com.ui.spring.springboot2jpacrudexample.model.Slider;
import com.ui.spring.springboot2jpacrudexample.model.UserAddress;
import com.ui.spring.springboot2jpacrudexample.model.UserDetail;
import com.ui.spring.springboot2jpacrudexample.model.view.ProductListDefaultView;
import com.ui.spring.springboot2jpacrudexample.repository.ProductRepository;
import com.ui.spring.springboot2jpacrudexample.service.AuthorService;
import com.ui.spring.springboot2jpacrudexample.service.CategoryService;
import com.ui.spring.springboot2jpacrudexample.service.CurrencyService;
import com.ui.spring.springboot2jpacrudexample.service.InquiryService;
import com.ui.spring.springboot2jpacrudexample.service.OrderItemService;
import com.ui.spring.springboot2jpacrudexample.service.OrderService;
import com.ui.spring.springboot2jpacrudexample.service.ProductService;
import com.ui.spring.springboot2jpacrudexample.service.ProductTabService;
import com.ui.spring.springboot2jpacrudexample.service.RegisterUserService;
import com.ui.spring.springboot2jpacrudexample.service.SliderService;
import com.ui.spring.springboot2jpacrudexample.service.UserAddressService;
import com.ui.spring.springboot2jpacrudexample.service.UserService;

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
	
	@Autowired
	private InquiryService inquiryService;
	
	@Autowired
	private OrderService orderService; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderItemService itemService;
	
	@Autowired
	private ProductTabService productTabService;
	
	
	
	@RequestMapping("/")
	public String  home(Model model,HttpSession session) {
		
		//System.out.println(currencyService.getDefaultCurrency().getCurrencySymbol());
		
		session.setAttribute("currencySymbol",currencyService.getDefaultCurrency().getCurrencySymbol());
		
		model.addAttribute("sliderList", sliderService.getActiveSliders());
		model.addAttribute("authorList", authorService.getActiveAuthors());
		
		model.addAttribute("categories",categoryRepository.getActiveCategory());
		
		List<Product> products = productRepository.getFeaturedProduct();
		
		for (int i = 0; i < products.size(); i++) {
			if(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).isPresent())
				products.get(i).setCurrency(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).get());
		}
		model.addAttribute("featuredProduct",products.stream().map(this::convertToDto).collect(Collectors.toList()));
		
		return "index";
	}
	 
	@RequestMapping("/getFeaturedProductList" )
	@ResponseBody public List<ProductListDefaultView>  getFeaturedProductList() {
		return productRepository.getFeaturedProduct().stream().map(this::convertToDefaultDto).collect(Collectors.toList());
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
			
			List<Product> products = productRepository.getProductByCategory(Long.parseLong(categoryId+""));
			for (int i = 0; i < products.size(); i++) {
				if(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).isPresent())
					products.get(i).setCurrency(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).get());
			}
			model.addAttribute("productList",products.stream().map(this::convertToDto).collect(Collectors.toList()));
		return "product_list";
	}
	
	@RequestMapping("/featured/product")
	public String  featured(Model model) {
		
		List<Product> products = productRepository.getFeaturedProduct();
		for (int i = 0; i < products.size(); i++) {
			if(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).isPresent())
				products.get(i).setCurrency(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).get());
		}
		model.addAttribute("productList",products.stream().map(this::convertToDto).collect(Collectors.toList()));
			
		return "featured_product_list";
	}
	 
	@RequestMapping("/product/{productId}")
	public String  product(@PathVariable("productId") int categoryId,Model model) {
		
			Product product = productRepository.getProductById(Long.parseLong(categoryId+""));
		
			if(product!=null){
				
				
				if(currencyService.getCurrencyById(Long.parseLong(product.getCurrencyId()+"")).isPresent())
					product.setCurrency(currencyService.getCurrencyById(Long.parseLong(product.getCurrencyId()+"")).get());
				
				if(authorService.getAuthorById(Long.parseLong(product.getAuthorId()+"")).isPresent())
					model.addAttribute("author",authorService.getAuthorById(Long.parseLong(product.getAuthorId()+"")).get());
				
				if(categoryRepository.getCategoryById(Long.parseLong(product.getCategoryId()+"")).isPresent())
					model.addAttribute("category",categoryRepository.getCategoryById(Long.parseLong(product.getCategoryId()+"")).get());
				
				/*System.out.println(categoryRepository.getCategoryById(Long.parseLong(product.getCategoryId()+"")).get().getCategoryName());*/
				
				
				model.addAttribute("productTabList",productTabService.getActiveProductTabByProduct(Integer.parseInt(product.getId()+"")));
				}
				
			model.addAttribute("product",product);
			
		return "books_details";
	}
	
	
	 @RequestMapping("/authors")
     public String  getAllauthorss(Model model) {
         
         model.addAttribute("authors",authorService.getAllAuthors());
         
         
         return "authors";
     }
	 
	 @RequestMapping("/author/{authorId}")
     public String  getAllauthorss(Model model,@PathVariable(value = "authorId") Long authorId ) {
         
         model.addAttribute("authors",authorService.getAuthorById(authorId).get());
         return "authors_details";
     }
    
    @RequestMapping("/contact")
    public String  getAllcontact(Model model) {
     
        return "contact-us";
    }
    @RequestMapping("/book")
    public String  getAllbookes(Model model) {
        
    	
    	List<Product> products = productService.getAllProducts();
		
		for (int i = 0; i < products.size(); i++) {
			if(currencyService.getCurrencyById(Long.parseLong(products.get(i).getCurrencyId()+"")).isPresent())
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
    
    @RequestMapping("/deleteUserAddress" )
    @ResponseBody  public void deleteUserAddress(HttpSession session,String addressId) {
    	UserAddress userAddress = null;
    	if(userAddressService.getUserAddressById(Long.parseLong(addressId)).isPresent()){
		userAddress = userAddressService.getUserAddressById(Long.parseLong(addressId)).get();
		userAddress.setIsDeleted(1);
		}
		userAddressService.createAddress(userAddress);
    }
    
    @RequestMapping("/getGuestUserAddress" )
    @ResponseBody  public List<UserAddress> getGuestUserAddress(HttpSession session,String guestEmailAddress) {
		return userAddressService.getGuestUserAddress(guestEmailAddress);
    	
    }
    
    @RequestMapping("/getAddressById" )
    @ResponseBody  public UserAddress getAddressById(HttpServletRequest request) {
    	return userAddressService.getUserAddressById(Long.parseLong(request.getParameter("addressId")+"")).get();
    }
    
    @RequestMapping("/insertContactus" )
    @ResponseBody  public boolean insertContactus(Inquiry inquiry) {
    	  inquiryService.createInquiry(inquiry);
    	  MailConfiguration.sendMail("Inquiry Details",mailTemplate(inquiry));
    	  return true;
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
      
    	//System.out.println("-------------------This is call-------------------------");
    	
    	Integer userId = 0;
    	if(session.getAttribute("userId")!=null)    	
    		userId = Integer.parseInt(session.getAttribute("userId")+"");
    	
    	
    	Product product =  productService.getProductById(orderItem.getOrderId()).get();
    	if(authorService.getAuthorById(product.getAuthorId()).isPresent())
    		orderItem.setAuthorName(authorService.getAuthorById(product.getAuthorId()).get().getAuthorName());
    	
    	orderItem.setBookTitle(product.getBookTitle());
    	orderItem.setPrice(product.getOriginalPrice());
    	orderItem.setUserId(userId); 
    	orderItem.setImage(product.getImage());
    	
    	if(categoryRepository.getCategoryById(product.getCategoryId()).isPresent())
    		orderItem.setCategoryName(categoryRepository.getCategoryById(product.getCategoryId()).get().getCategoryName());
    	if(currencyService.getCurrencyById(Long.parseLong(product.getCurrencyId()+"")).isPresent())
    		orderItem.setCurrencySymbol(currencyService.getCurrencyById(Long.parseLong(product.getCurrencyId()+"")).get().getCurrencySymbol());
	
    	
    	List<OrderItem> items = new ArrayList<OrderItem>();
    	if(session.getAttribute("orderItem")==null) {
    		items.add(orderItem);
    		session.setAttribute("orderItem",items);
    		
    	}else {
    		items = (List<OrderItem>) session.getAttribute("orderItem");
    		
    		boolean checkStatus = true;
    		for (int i = 0; i < items.size(); i++) {
    			
    			//System.out.println(items.get(i).getOrderId() +"---"+orderItem.getOrderId());
    			
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
      
      
      if(user!=null) {
    	  
    	  System.out.println(user.getPassword() +"---"+request.getParameter("userPassword"));
          System.out.println("condiroin :::::"+user.getPassword().equals(request.getParameter("userPassword")));
          
    	  
    	  if(user.getPassword().equals(request.getParameter("userPassword"))) {
	    	  session.setAttribute("userId",user.getId());
	    	  session.setAttribute("userName",user.getYourName());
	    	  return true;
    	  	} 
    	  return false;
      }else {
    	  return false;
      }
    }
     
    
    @RequestMapping("/myProfile" )
    public String  myProfile(HttpSession session,Model model) {
      
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";	
    	}
    if(registerUserService.getRegisterUserById(Long.parseLong(session.getAttribute("userId")+"")).isPresent())	
    	model.addAttribute("userRegister",registerUserService.getRegisterUserById(Long.parseLong(session.getAttribute("userId")+"")).get());
    	
    		return "my_profile";	
    }
    
    @RequestMapping("/updateRegistration" )
    @ResponseBody public void  updateRegistration(HttpSession session,RegisterUser registerUser,HttpServletRequest request) {
    
    	 
    	
    	RegisterUser user = registerUserService.getRegisterUserById(Long.parseLong(session.getAttribute("userId")+"")).get();
    	registerUser.setId(user.getId());
    	registerUser.setTermsCondition(user.getTermsCondition());
    	registerUser.setPassword(user.getPassword());
    	registerUserService.createRegisterUser(registerUser);
    	
      if(user!=null) {
    	  session.setAttribute("userId",user.getId());
    	  session.setAttribute("userName",user.getYourName()); 
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
        
      //System.out.println("-------refund-&-cancellation------->>>");
      
        return "refund_cancellation";
    }
    
    @RequestMapping("/my_order")
    public String  my_order(HttpSession session,Model model) {
        
      //System.out.println("-------my-orders------->>>");
    	
    	if(session.getAttribute("userId")!=null) {
    		 Long userId =  (long) session.getAttribute("userId");
    	      model.addAttribute("orderList",orderService.getUserOrdersHistory(Long.parseLong(userId+"")));
    	      
    	      List<Order> orders =  orderService.getUserOrdersHistory(Long.parseLong(userId+""));
    	      for(int i=0;i < orders.size();i++) {
    	    	  System.out.println(orders.get(i).getAmount());
    	    	  System.out.println(orders.get(i).getDeliveryAdd1()+"-"+orders.get(i).getDeliveryAdd2());
    	      }
    	}
    	
     
      return "my_orders";
    }
    
    @RequestMapping("/orderDetails/{orderId}")
    public String  orderDetails(@PathVariable(value = "orderId") String orderId ,HttpSession session,Model model) {
    
    	System.out.println(orderService.getOrderById(Long.parseLong(orderId+"")).isPresent());
    	
    	if(orderService.getOrderById(Long.parseLong(orderId+"")).isPresent()){
    			model.addAttribute("orderList",orderService.getOrderById(Long.parseLong(orderId+"")).get());
    		}
    	
    	System.out.println(itemService.getUserOrderItemsHistory(Long.parseLong(orderId)).size());
    	
    	model.addAttribute("orderDetails",itemService.getUserOrderItemsHistory(Long.parseLong(orderId)));
    	
    	return "order_details";
    }
    
    @RequestMapping("/checkoutAddress")
    @ResponseBody public void  checkoutAddress(HttpSession session,String deliveryAddreessId) {
    	
    	System.out.println("checkoutAddress ::::"+deliveryAddreessId);
    	
    	
    	session.setAttribute("deliveryAddressId", deliveryAddreessId);
    }	
    
    @RequestMapping("/saveOrder")
    public String  saveOrder(HttpSession session,Model model) {
        
      //System.out.println("-------my-orders------->>>");
      Long userId =  (long) session.getAttribute("userId");
      //model.addAttribute("orderList",orderService.getUserOrdersHistory(Integer.parseInt(userId+"")));
      
      UserDetail userDetails = null;
      UserAddress userAddress = null;
      if(userService.getUserById(userId).isPresent()) {
    	   userDetails =  userService.getUserById(userId).get();  
      }
      
      System.out.println("USer address ::"+userAddressService.getUserAddressById(Long.parseLong(session.getAttribute("deliveryAddressId")+"")).isPresent());
      if(userAddressService.getUserAddressById(Long.parseLong(session.getAttribute("deliveryAddressId")+"")).isPresent()) {
    	  userAddress = userAddressService.getUserAddressById(Long.parseLong(session.getAttribute("deliveryAddressId")+"")).get();  
      }
      
      
      Order order = new Order();
      order.setAmount(0.0d);
      order.setCurrencyType("USD");
      order.setDeliveryAdd1(userAddress.getAdd1());
      order.setDeliveryAdd2(userAddress.getAdd2());
      order.setDeliveryCity(userAddress.getCity());
      order.setDeliveryCountry(userAddress.getCountry());
      order.setDeliveryMobileNumber(userAddress.getMobileNumber());
      order.setDeliveryPinCode(userAddress.getPinCode());
      order.setDeliveryState(userAddress.getState());
      order.setDeliveryUserEmail(userAddress.getUserEmail());
      order.setUserId(userId);
      
      order.setOrderStatus("Pending");
	     if(userDetails!=null){
	    	 order.setFullName(userDetails.getFirstName());
	    	 order.setEmailAddress(userDetails.getUserEmail());
	     }
      
      
      
      
      Order finalOrder = orderService.createOrder(order);
      
    @SuppressWarnings("unchecked")
	List<OrderItem> items =  (List<OrderItem>) session.getAttribute("orderItem");
    
    double finalAmount = 0.0d;
    double amount = 0.0d;
    int qty = 0;
    for(int i=0;i<items.size();i++) {
	    	OrderItems orderItems= new OrderItems();
	    	orderItems.setAuthorName(items.get(i).getAuthorName());
	    	orderItems.setBookTitle(items.get(i).getBookTitle());
	    	orderItems.setCategoryName(items.get(i).getCategoryName());
	    	orderItems.setCurrencySymbol(items.get(i).getCurrencySymbol());
	    	orderItems.setImage(items.get(i).getImage());
	    	orderItems.setOrderId(finalOrder.getId());
	    	orderItems.setPrice(items.get(i).getPrice());
	    	orderItems.setQty(items.get(i).getQty());
	    	orderItems.setUserId(items.get(i).getUserId());
	    	
	    	amount  =  (items.get(i).getQty() * items.get(i).getPrice()); 
	    	finalAmount = finalAmount + amount;
	    	qty += items.get(i).getQty();
	    	itemService.createOrderItem(orderItems);
	    }
      
    finalOrder.setOrderQty(qty);
    finalOrder.setAmount(finalAmount);
    orderService.createOrder(finalOrder);
    
    	session.setAttribute("orderItem",null);
    	session.setAttribute("deliveryAddressId",null);
    	session.setAttribute("","");
    	session.setAttribute("","");
    	session.setAttribute("","");
    
      return "redirect:/";
    }
    
    @RequestMapping("/changePasswprd")
    public String  changePasswprd(HttpSession session,Model model) {
        
      return "change_password";
    }
    
    @RequestMapping("/forgotPasswprd")
    public String  forgotPasswprd(HttpSession session,Model model) {
        
      return "forgot_password";
    }
    
    @RequestMapping("/updatePassword")
    @ResponseBody public boolean updatePassword(HttpSession session,String updatePassword) {
      Long userId =  (long) session.getAttribute("userId");
      RegisterUser registerUser = registerUserService.getRegisterUserById(userId).get();
      registerUser.setPassword(updatePassword);
      registerUserService.updateRegisterUser(registerUser);
      return true;
    }
    
    @RequestMapping("/checkUserPassword")
    @ResponseBody public boolean  checkUserPassword(HttpSession session,String currentPassword) {
      Long userId =  (long) session.getAttribute("userId"); 
      return registerUserService.getRegisterUserById(userId).get().getPassword().equals(currentPassword);
      
    }
    
    @RequestMapping("/forgotPasswordSendMail")
    @ResponseBody public boolean forgotPasswordSendMail(HttpSession session,String FGemailAddress) {

    	System.out.println("GemailAddress-------->>>>"+FGemailAddress);
    	
    	RegisterUser userDetail = registerUserService.checkEmailAddress(FGemailAddress);
    	if(userDetail != null) {
    		String body = "Dear user, /n <a href='www.google.com' target='_blank'>  Please click on link to reset password.</a>";
        	MailConfiguration.sendMail("Forgot Password Link",body);
        	return true;
    	}else {
    		return false;
    	}
    }
    
    
    
    @RequestMapping("/setNewPassword")
    public String setNewPassword(HttpSession session,String FGemailAddress,Model model) {

    	System.out.println("GemailAddress-------->>>>"+FGemailAddress);
    	
    	RegisterUser userDetail = registerUserService.checkEmailAddress(FGemailAddress);
    	if(userDetail != null) {
    		
    		model.addAttribute("FGemailAddress", FGemailAddress);
    		
    		//String body = "Dear user, /n <a href='www.google.com' target='_blank'>  Please click on link to reset password.</a>";
        	//MailConfiguration.sendMail("Forgot Password Link",body);
    	}else{
    		return "redirect:/";
    	}
    	return "reset_password";
    }
    
    @RequestMapping("/resetPassword")
    @ResponseBody public boolean resetPassword(HttpSession session,HttpServletRequest request) {
      
      RegisterUser registerUser = registerUserService.checkEmailAddress(request.getParameter("FGemailAddress"));
      if(registerUser!=null) {
    	  //System.out.println("updatePassword---------->>>"+request.getParameter("updatePassword"));
    	  registerUser.setPassword(request.getParameter("updatePassword"));
          registerUserService.updateRegisterUser(registerUser);
          return true;  
      }else {
    	  return false;
      }
    }
    
    @RequestMapping("/checkUserStatus")
    @ResponseBody public boolean  checkUserStatus(HttpSession session,String value,String  action) {
      RegisterUser registerUser = new RegisterUser();
      if(action.equalsIgnoreCase("userName")) {
    	  registerUser = registerUserService.checkUserName(value);
      }else if(action.equalsIgnoreCase("userEmail")){
    	  registerUser = registerUserService.checkEmailAddress(value);
      }
      
      //System.out.println("User naem ::"+value +"------"+action);
      
      if(registerUser!=null) {
    	  return true;
      }else {
    	  return false;
      }
      
      
    }
    
    @RequestMapping("/setDefaultAddress")
    @ResponseBody public boolean  setDefaultAddress(HttpSession session,long  id) {
    
    	Integer userId = 0;
  		if(session.getAttribute("userId")!=null)    	
		{
  			
  			
			userId = Integer.parseInt(session.getAttribute("userId")+"");
			
			System.out.println(userId +"---"+ id);
			
			userAddressService.updateDefaultAddressByUserId(userId);
			userAddressService.setDefaultAddressById(id);
		}
    	return false;
    } 	
    
    
    @RequestMapping("/manage_address")
    public String  manage_address(HttpSession session,Model model) {
        
      //System.out.println("-------manage_address------->>>");
      Integer userId = 0;
  		if(session.getAttribute("userId")!=null)    	
		{
			userId = Integer.parseInt(session.getAttribute("userId")+"");
			return "manage_addresses";
		}else {
			return "redirect:/";
		}
  		
        
    }
    
    @RequestMapping("/terms_conditions")
    public String  terms_conditions(Model model) {
        
      //System.out.println("-------terms-conditions------->>>");
      
        return "terms_conditions";
    }
    @RequestMapping("/privacy_policy")
    public String  privacy_policy(Model model) {
        
      //System.out.println("-------privacy-policy------->>>");
      
        return "privacy_policy";
    }
    
    @RequestMapping("/cart")
    public String  cart(Model model) {
        
      //System.out.println("-------privacy-policy------->>>");
      
        return "privacy_policy";
    }

    public ProductDTO convertToDto(Product Product) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ProductDTO ProductDTO = modelMapper.map(Product, ProductDTO.class);
		return ProductDTO;
	}
    
    public ProductListDefaultView convertToDefaultDto(Product Product) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ProductListDefaultView ProductDTO = modelMapper.map(Product, ProductListDefaultView.class);
		return ProductDTO;
	}
    
    

    public String mailTemplate(Inquiry inquiry) {
    	
    	String html = "<html><head>"+
    	"<style>"+
    	"table {"+
    	  "font-family: arial, sans-serif;"+
    	  "border-collapse: collapse;"+
    	  "width: 100%;"+
    	"}"+

    	"td, th {"+
    	  "border: 1px solid #dddddd;"+
    	  "text-align: left;"+
    	  "padding: 8px;"+
    	"}"+

    	"tr:nth-child(even) {"+
    	  "background-color: #dddddd;"+
    	"}"+
    	"</style>"+
    	"</head>"+
    	"<body>"+

    	"<h2>Inquiry Details</h2>"+

    	"<table>"+
    	  "<tr>"+
    	    "<th>Full Name</th>"+
    	    "<th>Email Address</th>"+
    	    "<th>Contact</th>"+
    	    "<th>Subject</th>"+
    	    "<th>Message</th>"+
    	  "</tr>"+
    	  "<tr>"+
    	   " <td>"+inquiry.getFullName() +"</td>"+
    	    "<td>"+inquiry.getEmailAddress() +"</td>"+
    	    "<td>"+inquiry.getContactNumber() +"</td>"+
    	    "<td>"+inquiry.getContactSubject() +"</td>"+
    	    "<td>"+inquiry.getMessage() +"</td>"+
    	  "</tr>"+
    	"</table>"+

    	"</body>"+
    	"</html>";
    	
    	return html;
    }
    
}
