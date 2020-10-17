/**
 * AuthorizePaymentServlet class - requests PayPal for payment.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.ui.spring.springboot2jpacrudexample.payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.paypal.base.rest.PayPalRESTException;

//@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthorizePaymentServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = "Next iPhone";//request.getParameter("product");
		String subtotal = "100";//request.getParameter("subtotal");
		String shipping = "10";//request.getParameter("shipping");
		String tax = "10"; //request.getParameter("tax");
		String total = "120"; //request.getParameter("total");
		
		OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);
System.out.println(orderDetail.getTotal()+"--------------------"+orderDetail.getProductName());
		try {
			PaymentServices paymentServices = new PaymentServices();
			/*String approvalLink = paymentServices.authorizePayment(orderDetail);

			response.sendRedirect(approvalLink);
			*/
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
