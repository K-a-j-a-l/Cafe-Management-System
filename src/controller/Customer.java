package controller;

import model.M_customer;

public class Customer {
	Order order=new Order();
	M_customer obj_M_customer=new M_customer();
	
	public Customer() {
		this.order=order;
	}
	public void rateService(String customerId, String rate) {
		obj_M_customer.rateService(customerId, rate);
	}
	
	public void order(String customerId, String bill) {
		
	}
}
