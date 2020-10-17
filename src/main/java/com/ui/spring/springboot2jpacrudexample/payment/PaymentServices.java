/**
 * PaymentServices class - encapsulates PayPal payment integration functions.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.ui.spring.springboot2jpacrudexample.payment;

import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentServices {
	//private static final String CLIENT_ID = "AUinWpNH3ufT63jgYO-zFRnzwlBhLwfDc7UckP3_Lz-3ZRB_blrRtVYkXg2n3uEjd2uVFpKrVpeHqXnO";
	//private static final String CLIENT_SECRET = "EEus-ZyBJcLzddc5hMpA6gjNlBqBpT_bRDHaSyOYNVIFOpOT_KrWf5PsHO_2d-3yGbW-2MotPhzyTt7h";
	private static final String CLIENT_ID = "AUinWpNH3ufT63jgYO-zFRnzwlBhLwfDc7UckP3_Lz-3ZRB_blrRtVYkXg2n3uEjd2uVFpKrVpeHqXnO";
	private static final String CLIENT_SECRET = "EEus-ZyBJcLzddc5hMpA6gjNlBqBpT_bRDHaSyOYNVIFOpOT_KrWf5PsHO_2d-3yGbW-2MotPhzyTt7h";
	private static final String MODE = "sandbox";

	public String authorizePayment(OrderDetail orderDetail,Payer payer)			
			throws PayPalRESTException {		

		System.out.println("orderDetail-------------"+orderDetail);
		
		//payer = getPayerInformation();
		RedirectUrls redirectUrls = getRedirectURLs();
		List<Transaction> listTransaction = getTransactionInformation(orderDetail);
		
		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		
		System.out.println("apiContext-----------"+apiContext);
		
		Payment approvedPayment = requestPayment.create(apiContext);

		System.out.println("=== CREATED PAYMENT: ====");
		System.out.println(approvedPayment);

		return getApprovalLink(approvedPayment);

	}
	
	private Payer getPayerInformation() {
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		
		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName("John")
				 .setLastName("Doe")
				 .setEmail("sb-m43vyv3164301@personal.example.com");
		
		payer.setPayerInfo(payerInfo);
		
		return payer;
	}
	
	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://frangipanibookstest.com/cancel.jsp");
		//redirectUrls.setReturnUrl("http://localhost:8080/springboot-crud-rest/review_payment");
		redirectUrls.setReturnUrl("http://frangipanibookstest.com/review_payment");
		return redirectUrls;
	}
	
	private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
		
		System.out.println("getShipping()--------->");
		
		System.out.println("getShipping()--------->"+orderDetail.getShipping());
		System.out.println("getTotal()--------->"+orderDetail.getTotal());
		
		
		Details details = new Details();
		details.setShipping(orderDetail.getShipping());
		details.setSubtotal(orderDetail.getSubtotal());
		details.setTax(orderDetail.getTax());

		
		
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(orderDetail.getTotal());
		amount.setDetails(details);

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(orderDetail.getProductName());
		
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<>();
		
		Item item = new Item();
		item.setCurrency("USD");
		item.setName(orderDetail.getProductName());
		item.setPrice(orderDetail.getSubtotal());
		item.setTax(orderDetail.getTax());
		item.setQuantity("1");
		
		items.add(item);
		itemList.setItems(items);
		transaction.setItemList(itemList);

		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction);	
		
		return listTransaction;
	}
	
	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;
		
		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink = link.getHref();
				break;
			}
		}		
		
		return approvalLink;
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment payment = new Payment().setId(paymentId);

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		return payment.execute(apiContext, paymentExecution);
	}
	
	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}
}
