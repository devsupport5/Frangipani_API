package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Address;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import com.ui.spring.springboot2jpacrudexample.model.Order;
import com.ui.spring.springboot2jpacrudexample.model.OrderItem;
import com.ui.spring.springboot2jpacrudexample.model.OrderItems;
import com.ui.spring.springboot2jpacrudexample.model.PaypalTransaction;
import com.ui.spring.springboot2jpacrudexample.model.RegisterUser;
import com.ui.spring.springboot2jpacrudexample.model.UserAddress;
import com.ui.spring.springboot2jpacrudexample.model.UserDetail;
import com.ui.spring.springboot2jpacrudexample.payment.OrderDetail;
import com.ui.spring.springboot2jpacrudexample.payment.PaymentServices;
import com.ui.spring.springboot2jpacrudexample.repository.PaypalTransactionRepository;
import com.ui.spring.springboot2jpacrudexample.service.OrderItemService;
import com.ui.spring.springboot2jpacrudexample.service.OrderService;
import com.ui.spring.springboot2jpacrudexample.service.RegisterUserService;
import com.ui.spring.springboot2jpacrudexample.service.UserAddressService;
import com.ui.spring.springboot2jpacrudexample.service.UserService;

@Controller
public class PaymentController {

	@Autowired
	private OrderService orderService; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAddressService userAddressService;
	
	@Autowired
	private OrderItemService itemService;
	
	@Autowired
	RegisterUserService registerUserService;
	
	@Autowired
	private PaypalTransactionRepository paypalTransactionRepository;
	
	 @RequestMapping("/authorize_payment")
	 public String authorize_payment(HttpSession session,HttpServletResponse response,HttpServletRequest request) {
		 
		 
		 List<OrderItem> items =  (List<OrderItem>) session.getAttribute("orderItem");
		
		 float finalPrice = 0.0f;
		 float price = 0.0f;
		 for (int i = 0; i < items.size(); i++) {
			
			 price = (float) (items.get(i).getPrice());
			 finalPrice = price + finalPrice;
		}
		 
		 String product = "Books";//request.getParameter("product");
			String subtotal = finalPrice+"";//request.getParameter("subtotal");
			String shipping = "0";//request.getParameter("shipping");
			String tax = "0"; //request.getParameter("tax");
			String total = finalPrice+""; //request.getParameter("total");
		 OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);
		 
		 try {
			 
			 	Payer payer = new Payer();
			 	payer.setPaymentMethod("paypal");
			 	
			 	
			 	RegisterUser user = registerUserService.getRegisterUserById(Long.parseLong(session.getAttribute("userId")+"")).get();
			 	
			 	UserAddress userAddress = null;
			 	if(userAddressService.getUserAddressById(Long.parseLong(session.getAttribute("deliveryAddressId")+"")).isPresent()) {
			    	  userAddress = userAddressService.getUserAddressById(Long.parseLong(session.getAttribute("deliveryAddressId")+"")).get();  
			      }
			 	
			 	ShippingAddress address = new ShippingAddress();
			 	address.setCity(userAddress.getCity());
			 	address.setLine1(userAddress.getAdd1());
			 	address.setLine2(userAddress.getAdd2());
			 	//address.setCountryCode(userAddress.getCountry());
			 	address.setRecipientName(userAddress.getFullName());
			 	address.setPhone(userAddress.getMobileNumber());
			 	//address.setPostalCode(userAddress.getPinCode());
			 	address.setState(userAddress.getState());
			 	//address.setCountryCode(userAddress.getPinCode());
			 	//address.setNormalizationStatus(userAddress.getSpecialInstruction());
			 	
			 	Address address2 = new Address();
			 	address2.setCity(userAddress.getCity());
			 	address2.setLine1(userAddress.getAdd1());
			 	address2.setLine2(userAddress.getAdd2());
			 	//address2.setCountryCode(userAddress.getCountry());
			 	address2.setPhone(userAddress.getMobileNumber());
			 	//address2.setPostalCode(userAddress.getPinCode());
			 	address2.setState(userAddress.getState());
			 	//address2.setCountryCode(userAddress.getPinCode());
			 	//address2.setNormalizationStatus(userAddress.getSpecialInstruction());
			 	
			 	PayerInfo payerInfo = new PayerInfo();
				payerInfo.setFirstName(user.getYourName())
						 .setEmail(user.getUserEmail());//.setShippingAddress(address).setBillingAddress(address2);
				
				//payerInfo.setCountryCode("IN");
				
				payer.setPayerInfo(payerInfo);
				
				
			 
				PaymentServices paymentServices = new PaymentServices();
				String approvalLink = paymentServices.authorizePayment(orderDetail,payer);

				System.out.println("approvalLink---------->"+approvalLink);
				//response.sendRedirect(approvalLink);
				return "redirect:"+approvalLink;
				
			} catch (PayPalRESTException ex) {
				request.setAttribute("errorMessage", ex.getMessage());
				ex.printStackTrace();
				//request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		return "";
	 }
	 
	 @RequestMapping("/review_payment")
	 public String review_payment(HttpSession session,HttpServletResponse response,HttpServletRequest request) {
	
		 String paymentId = request.getParameter("paymentId");
			String payerId = request.getParameter("PayerID");
			PaypalTransaction paypalTransaction =  new PaypalTransaction();
			try {
				PaymentServices paymentServices = new PaymentServices();
				Payment payment = paymentServices.getPaymentDetails(paymentId);
				
				PayerInfo payerInfo = payment.getPayer().getPayerInfo();
				Transaction transaction = payment.getTransactions().get(0);
				ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
				
				
				
				
				request.setAttribute("payer", payerInfo);
				request.setAttribute("transaction", transaction);
				request.setAttribute("shippingAddress", shippingAddress);
				
				
				/*System.out.println(payerInfo.getFirstName()+"---"+payerInfo.getLastName()+"---"+payerInfo.getBillingAddress().getCity());
				System.out.println(payerInfo.getFirstName()+"---"+payerInfo.getBillingAddress().getLine1()+"---"+payerInfo.getBillingAddress().getLine1());
				*/
				
				payerInfo.getAccountNumber();
				
				
				
				paypalTransaction.setFirstName((payerInfo.getFirstName()!=null)?payerInfo.getFirstName():"");
				paypalTransaction.setLastName((payerInfo.getLastName()!=null)?payerInfo.getLastName():"");
				/*paypalTransaction.setCity((payerInfo.getBillingAddress().getCity()!=null)?payerInfo.getBillingAddress().getCity():"");
				paypalTransaction.setState((payerInfo.getBillingAddress().getState()!=null)?payerInfo.getBillingAddress().getState():"");
				paypalTransaction.setCountryCode((payerInfo.getBillingAddress().getCountryCode()!=null)?payerInfo.getBillingAddress().getCountryCode():"");
				paypalTransaction.setLine1((payerInfo.getBillingAddress().getLine1()!=null)?payerInfo.getBillingAddress().getLine1():"");*/
				paypalTransaction.setTotal((transaction.getAmount().getTotal()!=null)?transaction.getAmount().getTotal():"");
				/*paypalTransaction.setPostalCode((shippingAddress.getPostalCode()!=null)?shippingAddress.getPostalCode():"");*/
				paypalTransaction.setPayerID(payerId);
				paypalTransaction.setPaymentId(paymentId);
				paypalTransaction.setEmail((payerInfo.getEmail()!=null)?payerInfo.getEmail():"");
				paypalTransaction.setAccountNumber(payment.getPayer().getPayerInfo().getAccountNumber());
				paypalTransaction.setPaymentMethod(payment.getPayer().getPaymentMethod());
				paypalTransaction.setOrderStatus(payment.getPayer().getStatus());
				
				
				
				//paypalTransaction.setPaymentMethod(pa);
				
				
				//paypalTransaction.set
				
				PaypalTransaction paypalTransaction2 = paypalTransactionRepository.save(paypalTransaction);
				
				//String url = "review.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;
				
				//request.getRequestDispatcher(url).forward(request, response);
				
			} catch (PayPalRESTException ex) {
				request.setAttribute("errorMessage", ex.getMessage());
				ex.printStackTrace();
				//request.getRequestDispatcher("error.jsp").forward(request, response);
				return "rediret:error_pyment";
			}	
			
			
			
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
		      order.setCurrencyType("GHS");
		      order.setBillerName(paypalTransaction.getFirstName()+" "+paypalTransaction.getLastName());
		      order.setDeliveryAdd1(userAddress.getAdd1());
		      order.setDeliveryAdd2(userAddress.getAdd2());
		      order.setDeliveryCity(userAddress.getCity());
		      order.setDeliveryCountry(userAddress.getCountry());
		      order.setDeliveryMobileNumber(userAddress.getMobileNumber());
		      order.setDeliveryPinCode(userAddress.getPinCode());
		      order.setDeliveryState(userAddress.getState());
		      order.setDeliveryUserEmail(userAddress.getUserEmail());
		      order.setPayerID(payerId);
		      order.setPaymentId(paymentId);
		      order.setBillerEmail(paypalTransaction.getEmail());
		      order.setUserId(userId);
		      order.setAccountNumber(paypalTransaction.getAccountNumber());
		      order.setPaymentMethod(paypalTransaction.getPaymentMethod());
		      order.setPaymentStatus(paypalTransaction.getOrderStatus());
		      order.setOrderStatus("NEW");
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
		    
		    paypalTransaction.setOrderId(Integer.parseInt(finalOrder.getId()+""));
		    paypalTransactionRepository.save(paypalTransaction);
		    
		    	session.setAttribute("orderItem",null);
		    	session.setAttribute("deliveryAddressId",null);
		    	session.setAttribute("","");
		    	session.setAttribute("","");
		    	session.setAttribute("","");
		    
		      return "redirect:thankyou?orderId="+order.getId()+"&transaactionId="+paypalTransaction.getPaymentId();
			
		 
	 } 
	 
	 @RequestMapping("/thankyou")
	 public String thankyou(Model model,HttpServletRequest request) {
	
		 model.addAttribute("orderId",request.getParameter("orderId"));
		 model.addAttribute("transactionNumber",request.getParameter("transaactionId"));
		 model.addAttribute("","");
		 model.addAttribute("","");
		 
		 return "thankyou";
	 }
	 
	 //error
	 @RequestMapping("/error_pyment")
	 public String error_pyment(HttpSession session,HttpServletResponse response,HttpServletRequest request) {
	
		 
		 return "error_pyment";
	 }
	
}
