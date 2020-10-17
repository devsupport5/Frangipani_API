/**
 * OrderDetail class - represents payment details.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.ui.spring.springboot2jpacrudexample.model;

public class OrderDetail {
	private String productName;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;
	private int orderQty; 

	public OrderDetail(String productName, String subtotal, 
			String shipping, String tax, String total,String orderQty) {
		this.productName = productName;
		this.subtotal = Float.parseFloat(subtotal);
		this.shipping = Float.parseFloat(shipping);
		this.tax = Float.parseFloat(tax);
		this.total = Float.parseFloat(total);
		this.orderQty = Integer.parseInt(orderQty);
	}

	public String getProductName() {
		return productName;
	}

	public String getSubtotal() {
		return String.format("%.2f", subtotal);
	}

	public String getShipping() {
		return String.format("%.2f", shipping);
	}

	public String getTax() {
		return String.format("%.2f", tax);
	}
	
	public String getTotal() {
		return String.format("%.2f", total);
	}
	
	public int getOrderQty() {
		return orderQty;
	}
}
